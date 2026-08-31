#include <bits/stdc++.h>
using namespace std;
long long a, b, c, d;
char A[15], B[15], C[15], D[15];
int n;
long long zzz(char q[]) {
  long long tam = 0;
  for (int i = strlen(q) - 1; i >= 0; i--) tam = tam * 30 + q[i] - 'a' + 1;
  return tam;
}
void xxx(long long w) {
  while (w > 0) {
    int tam = w % 30;
    w /= 30;
    cout << char(tam + 'a' - 1);
  }
}
int main() {
  cin >> A >> B;
  a = zzz(A);
  b = zzz(B);
  xxx(a);
  cout << ' ';
  xxx(b);
  cout << endl;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> C >> D;
    c = zzz(C);
    d = zzz(D);
    if (a == c)
      a = d;
    else if (b == c)
      b = d;
    else if (a == d)
      a = c;
    else if (b == d)
      b = c;
    xxx(a);
    cout << ' ';
    xxx(b);
    cout << endl;
  }
}
