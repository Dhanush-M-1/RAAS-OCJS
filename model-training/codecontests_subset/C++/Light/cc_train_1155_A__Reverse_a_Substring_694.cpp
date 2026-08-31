#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  while (cin >> n) {
    string s;
    cin >> s;
    long long x = 0;
    long long y = 0;
    long long flag = 0;
    for (long long i = 0; i < s.size() - 1; i++) {
      if (s[i] > s[i + 1]) {
        x = i + 1;
        y = i + 2;
        flag = 1;
        break;
      }
    }
    if (flag == 0) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl << x << " " << y << endl;
    }
  }
}
