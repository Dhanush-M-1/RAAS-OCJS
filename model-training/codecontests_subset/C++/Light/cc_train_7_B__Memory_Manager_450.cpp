#include <bits/stdc++.h>
using namespace std;
void hora() {
  time_t t;
  time(&t);
  struct tm* petm = localtime(&t);
  FILE* pfile;
  pfile = fopen("compilaciones.txt", "a");
  fprintf(pfile, " \n");
  fprintf(pfile, "compil�: %s\n", asctime(petm));
  fclose(pfile);
}
int mm[128];
int T, m;
int main() {
  string cad;
  int cnt = 0, t, i, j;
  cin >> T >> m;
  for (int z = 0; z < T; z++) {
    cin >> cad;
    if (cad[0] == 'a') {
      cin >> t;
      for (i = 0, j = -1; i < m; i++) {
        if (!mm[i] && i - j >= t)
          break;
        else if (mm[i])
          j = i;
      }
      if (i < m) {
        cout << (++cnt) << endl;
        for (++j; j <= i; j++) mm[j] = cnt;
      } else
        puts("NULL");
    } else if (cad[0] == 'e') {
      cin >> t;
      for (i = j = 0; i < m; i++)
        if (mm[i] == t) mm[i] = 0, j = 1;
      if (!j || t == 0) puts("ILLEGAL_ERASE_ARGUMENT");
    } else
      for (i = j = 0; i < m; i++)
        if (mm[i]) t = mm[i], mm[i] = 0, mm[j++] = t;
  }
}
