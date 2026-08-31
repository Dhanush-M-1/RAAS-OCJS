#include <bits/stdc++.h>
void swap(char *xp, char *yp) {
  char temp = *xp;
  *xp = *yp;
  *yp = temp;
}
void wypisz(char arr[], int size) {
  int i;
  for (i = 0; i < size; i++) printf("%c", arr[i]);
  printf("\n");
}
int main() {
  char matma[100];
  int i, j;
  scanf("%s", matma);
  int l = strlen(matma);
  for (i = 0; i < l; i += 2)
    for (j = 0; j < l - i - 1; j += 2)
      if (matma[j] > matma[j + 2]) swap(&matma[j], &matma[j + 2]);
  wypisz(matma, l);
}
