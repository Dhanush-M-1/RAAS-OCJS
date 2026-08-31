#include <bits/stdc++.h>
using namespace std;
long long ar[100005], n, flag;
int main() {
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    long long l, r;
    cin >> l >> r;
    ar[l]++;
    ar[r]++;
  }
  for (int i = 0; i < n + 1; i++)
    if (ar[i] == 2) flag = 1;
  if (!flag)
    cout << "YES";
  else
    cout << "NO";
}
