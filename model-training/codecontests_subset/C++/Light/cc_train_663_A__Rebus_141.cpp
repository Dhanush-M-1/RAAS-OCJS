#include <bits/stdc++.h>
using namespace std;
int b[2];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string a;
  int num;
  b[1] = 1;
  while (true) {
    char c;
    cin >> c;
    if (c == '=') {
      cin >> num;
      break;
    }
    if (c == '+' or c == '-') {
      ++b[c == '+'];
      a += c;
    }
  }
  if (b[0] == 0) {
    int avg = num / b[1];
    int need = num % b[1];
    if (!avg or avg + (need > 0) > num) {
      cout << "Impossible\n";
      return 0;
    }
    cout << "Possible\n";
    cout << avg + (need-- > 0) << " ";
    for (long long int j = 0; j < b[1] - 1 + b[0]; j++) {
      cout << a[j] << " " << avg + (need-- > 0) << " ";
    }
    cout << "= " << num;
    return 0;
  }
  int cnt = 1;
  while (true) {
    int avgp = (num + cnt) / b[1], avgn = cnt / b[0];
    int needp = (num + cnt) % b[1], needn = cnt % b[0];
    if (avgp + (needp > 0) > num or avgn + (needn > 0) > num) {
      break;
    }
    if (!avgp or !avgn) {
      ++cnt;
      continue;
    }
    cout << "Possible\n";
    cout << avgp + (needp-- > 0) << " ";
    for (long long int j = 0; j < b[1] - 1 + b[0]; j++) {
      cout << a[j] << " ";
      if (a[j] == '+') {
        cout << avgp + (needp-- > 0) << " ";
      } else {
        cout << avgn + (needn-- > 0) << " ";
      }
    }
    cout << "= " << num;
    return 0;
  }
  cout << "Impossible\n";
  return 0;
}
