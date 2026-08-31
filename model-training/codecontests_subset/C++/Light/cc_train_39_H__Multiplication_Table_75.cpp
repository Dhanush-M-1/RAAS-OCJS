#include <bits/stdc++.h>
using namespace std;
const int MAXN = 20;
int arr[MAXN][MAXN];
int n;
void F(int a) {
  string s;
  while (a >= n) {
    s += (a % n) + '0';
    a /= n;
  }
  s += a + '0';
  reverse(s.begin(), s.end());
  cout << s << " ";
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) F(i * j);
    cout << endl;
  }
}
