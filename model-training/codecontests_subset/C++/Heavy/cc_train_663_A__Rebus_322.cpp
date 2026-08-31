#include <bits/stdc++.h>
using namespace std;
int n, m, jia, jian;
char ch[2000010];
int a[1000010];
bool b[1000010];
int main() {
  gets(ch);
  int i = 0;
  jia = 0, jian = 0;
  int s = 0;
  while (ch[i] != '=') {
    i++;
    if (ch[i] == '-')
      jian++, b[++s] = true;
    else if (ch[i] == '+')
      jia++, b[++s] = false;
  }
  int n = strlen(ch) - 1;
  m = 0;
  while (i < n) {
    i++;
    if (int(ch[i]) >= 48 && int(ch[i]) <= 48 + 9) m = m * 10 + int(ch[i]) - 48;
  }
  jia++;
  int p = m;
  b[0] = false;
  if (m <= jia * m - jian && m >= jia - jian * m) {
    cout << "Possible" << endl;
    if (jia > jian) {
      for (int i = 1; i <= s; i++)
        if (b[i]) a[i] = p, m += p;
      for (int i = 0; i <= s; i++)
        if (!b[i]) a[i] = 1, m -= 1;
      for (int i = 0; i <= s; i++)
        if (!b[i]) {
          if (m > p - 1)
            m -= p - 1, a[i] = p;
          else
            a[i] = 1 + m, m = 0;
          if (m == 0) break;
        }
    } else if (jia == jian) {
      for (int i = 0; i <= s; i++) a[i] = 1;
      for (int i = 0; i <= s; i++)
        if (!b[i]) {
          if (m > p - 1)
            m -= p - 1, a[i] = p;
          else
            a[i] = 1 + m, m = 0;
          if (m == 0) break;
        }
    } else {
      for (int i = 0; i <= s; i++)
        if (!b[i]) a[i] = p, m -= p;
      for (int i = 1; i <= s; i++)
        if (b[i]) a[i] = 1, m += 1;
      for (int i = 1; i <= s; i++)
        if (b[i]) {
          if (m + p - 1 < 0)
            m += p - 1, a[i] = p;
          else
            a[i] = -m + 1, m = 0;
          if (m == 0) break;
        }
    }
    cout << a[0];
    for (int i = 1; i <= s; i++) {
      if (b[i])
        printf(" - ");
      else
        printf(" + ");
      printf("%d", a[i]);
    }
    cout << " = " << p << endl;
  } else
    cout << "Impossible" << endl;
  return 0;
}
