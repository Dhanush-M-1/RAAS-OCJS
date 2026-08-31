#include <bits/stdc++.h>
using namespace std;
int a[100500];
int b[100500];
int main() {
  string s;
  int k = 0;
  while (true) {
    cin >> s;
    cin >> s;
    if (s[0] == '=') {
      break;
    } else if (s[0] == '+') {
      a[k++] = 0;
    } else if (s[0] == '-') {
      a[k++] = 1;
    }
  }
  int n;
  cin >> n;
  int min_s = 1;
  int max_s = n;
  for (int i = 0; i < k; i++)
    if (a[i] == 0) {
      min_s += 1;
      max_s += n;
    } else {
      min_s -= n;
      max_s--;
    }
  if (min_s > n || max_s < n) {
    cout << "Impossible" << endl;
    return 0;
  }
  int ss = n;
  cout << "Possible" << endl;
  for (int i = 0; i <= k; i++) b[i] = 1;
  n--;
  for (int i = 0; i < k; i++)
    if (a[i])
      n++;
    else
      n--;
  if (n > 0) {
    b[0] = min(ss, n + 1);
    n -= b[0] - 1;
  }
  for (int i = 1; i <= k; i++)
    if (n > 0 && a[i - 1] == 0) {
      b[i] = min(ss, n + 1);
      n -= b[i] - 1;
    } else if (n < 0 && a[i - 1] == 1) {
      b[i] = min(ss, -n + 1);
      n += b[i] - 1;
    }
  cout << b[0] << ' ';
  for (int i = 1; i <= k; i++) {
    if (a[i - 1] == 0)
      cout << "+ ";
    else
      cout << "- ";
    cout << b[i] << " ";
  }
  cout << "= " << ss << endl;
  return 0;
}
