#include <bits/stdc++.h>
using namespace std;
vector<long long int> v;
set<long long int> s1;
set<long long int> s2;
set<string> st2;
vector<long long int> v1;
vector<long long int> v2;
vector<long long int> v3;
vector<long long int> v4;
vector<long long int> v5;
vector<pair<long long int, long long int> > v6;
vector<pair<long long int, long long int> > v16;
vector<string> v7;
vector<string> v8;
vector<char> v9;
vector<double> v11;
list<long long int> l;
int main() {
  long long int t;
  cin >> t;
  while (t-- > 0) {
    long long int n, m;
    cin >> n >> m;
    long long int a[n], b[m];
    long long int c[1001];
    for (long long int i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (long long int i = 0; i < m; i++) {
      cin >> b[i];
    }
    for (long long int i = 0; i < 1001; i++) {
      c[i] = 0;
    }
    for (long long int i = 0; i < n; i++) {
      c[a[i]] = 1;
    }
    long long int c1 = 0;
    long long int m1;
    for (long long int i = 0; i < m; i++) {
      if (c[b[i]] == 1) {
        c1++;
        m1 = b[i];
        break;
      }
    }
    if (c1 == 0)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << 1 << " " << m1 << endl;
    }
  }
  return 0;
}
