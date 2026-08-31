#include <bits/stdc++.h>
int main() {
  int i;
  int j;
  int n;
  scanf("%d", &n);
  char a[n];
  scanf("%s", a);
  int toplam = 0;
  int Isayisi = 0;
  int Fsayisi = 0;
  int Asayisi = 0;
  for (i = 0; i < n; i++) {
    switch (a[i]) {
      case 'A':
        Asayisi++;
        break;
      case 'F':
        Fsayisi++;
        break;
      case 'I':
        Isayisi++;
        break;
    }
  }
  if (Isayisi == 1)
    printf("1");
  else if (Isayisi > 1)
    printf("0");
  else
    printf("%d", Asayisi);
}
