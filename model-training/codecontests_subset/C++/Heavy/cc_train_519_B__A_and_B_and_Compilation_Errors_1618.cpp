#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  map<long long, int> m1;
  map<long long, int> md;
  vector<long long> a;
  map<long long, int> m2;
  map<long long, bool> mc;
  for (int i = 0; i < n; i++) {
    long long x;
    cin >> x;
    md[x]++;
    a.push_back(x);
  }
  for (int i = 0; i < n - 1; i++) {
    long long x;
    cin >> x;
    m1[x]++;
  }
  for (int i = 0; i < n - 2; i++) {
    long long x;
    cin >> x;
    m2[x]++;
  }
  for (int i = 0; i < n; i++)
    if (md[a[i]] > m1[a[i]]) {
      cout << a[i] << endl;
      m2[a[i]]++;
      mc[i] = true;
      break;
    }
  for (int i = 0; i < n; i++)
    if (md[a[i]] > m2[a[i]] && mc[i] == false) {
      cout << a[i];
      break;
    }
}
