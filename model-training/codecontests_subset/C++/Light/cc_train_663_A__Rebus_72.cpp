#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
const int N = 100005;
const int M = 10;
const string s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
char b[N];
int a[N];
int main() {
  string second;
  getline(cin, second);
  int n = 0, k = 0;
  for (int i = 0; i < second.size(); i++)
    if (second[i] >= '0' && second[i] <= '9') {
      k = k * 10 + (second[i] - '0');
    } else if (second[i] == '?')
      n++;
    else if (second[i] == '+' || second[i] == '-')
      b[n] = second[i];
  a[1] = k;
  int k1 = 0;
  for (int i = 1; i < n; i++) {
    if (b[i] == '+')
      k1++;
    else
      k1--;
    a[i + 1] = 1;
  }
  int p = k + k1;
  for (int i = 1; i < n; i++)
    if (b[i] == '+' && k > p) {
      int h = min(k - p, k - a[i + 1]);
      p += h;
      a[i + 1] += h;
    }
  for (int i = 0; i < n; i++)
    if ((b[i] == '-') && k < p) {
      int h = min(p - k, k - a[i + 1]);
      p -= h;
      a[i + 1] += h;
    }
  if (k < p) {
    int h = min(p - k, a[1] - 1);
    p -= h;
    a[1] -= h;
  }
  int t = a[1];
  for (int i = 1; i < n; i++)
    if (b[i] == '-')
      t -= a[i + 1];
    else
      t += a[i + 1];
  if (t != k) {
    cout << "Impossible"
         << "\n";
    return 0;
  }
  cout << "Possible"
       << "\n";
  cout << a[1] << " ";
  for (int i = 1; i < n; i++) cout << b[i] << " " << a[i + 1] << " ";
  cout << "= " << k << "\n";
}
