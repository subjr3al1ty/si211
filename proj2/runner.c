
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <ctype.h>

int main(int argc, const char** argv) {

  // This doesn't work unless I go unbuffered ... I don't know why linebuffered doesn't work
  int res = setvbuf(stdin, NULL, (1 ? _IONBF : _IOLBF), 0);
  char* buff = NULL;
  ssize_t n;
  ssize_t r = getline(&buff,&n,stdin);
  if (r == -1) {
    fprintf(stderr,"Error reading first line!");
    exit(1);
  }
  /* char tmp[2048]; */
  /* n = 0; */
  /* for(char c; (c = getchar()) && c != EOF && c != '\n'; tmp[n++] = c); */
  /* tmp[n++] = '\n'; */
  /* tmp[n] = '\0'; */
  /* ssize_t r = n; */
  /* buff = tmp; */

  /* turn whitespace into null chars */
  int count = 0;
  char prev = '\0';
  for(int i = 0; i < r; i++) {
    if (isspace(buff[i])) {
      buff[i] = '\0';
      if (prev != '\0')
	count ++;
    }
    prev = buff[i];
  }

  /* allocate array of strings */
  char** nargv = (char**)malloc(sizeof(char*)*(count+1));
  nargv[count] = NULL;

  /* fill array of strings */
  prev = '\0';
  for(int i = 0, k = 0; i < r; i++) {
    if (prev == '\0')
      nargv[k++] = &(buff[i]);
    prev = buff[i];
  }

  execvp(nargv[0],nargv);
  fprintf(stderr,"Exec failed in runner program!\n");
  exit(2);
  
  return 0;
}
