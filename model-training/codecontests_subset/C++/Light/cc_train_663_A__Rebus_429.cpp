#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const double eps = 1e-6;
const int mod = 1e9 + 7;
const int maxn = 1010;
int n;
int a, b;
int op[maxn];
int main() {
  int p = 0;
  a = 1;
  while (1) {
    char c;
    cin >> c;
    if (c == '+') {
      a++;
      op[++p] = 1;
    } else if (c == '-') {
      b++;
      op[++p] = -1;
    }
    if (c == '=') {
      cin >> n;
      break;
    }
  }
  if (n < a - b * n || n > a * n - b)
    puts("Impossible");
  else {
    cout << "Possible" << endl;
    int last = n + max(b, a - n);
    int last1 = max(b, a - n);
    int lastcnt = a;
    int lastcnt1 = b;
    int ans = n;
    int ans1 = n;
    if (last - n >= lastcnt - 1) {
      cout << n;
      last -= n;
    } else {
      ans = last - (lastcnt - 1);
      cout << ans;
      last -= ans;
    }
    lastcnt--;
    for (int i = 1; i <= p; i++) {
      if (op[i] == 1) {
        cout << " + ";
        if (last - n >= lastcnt - 1) {
          cout << n;
          last -= n;
        } else {
          ans = last - (lastcnt - 1);
          cout << ans;
          last -= ans;
        }
        lastcnt--;
      } else {
        cout << " - ";
        if (last1 - n >= lastcnt1 - 1) {
          cout << n;
          last1 -= n;
        } else {
          ans1 = last1 - (lastcnt1 - 1);
          cout << ans1;
          last1 -= ans1;
        }
        lastcnt1--;
      }
    }
    cout << " = " << n << endl;
  }
}
