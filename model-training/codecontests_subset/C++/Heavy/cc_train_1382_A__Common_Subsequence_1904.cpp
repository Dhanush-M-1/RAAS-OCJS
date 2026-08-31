#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, long long> > v;
stack<char> sta;
map<long long, long long> mp, pm;
priority_queue<long long> pq;
set<long long> st;
set<long long>::iterator P;
string s;
long long A[2000001], B[2000001], i, j, n, m, t, k, a, b, c, maxe, mine, sum;
char z;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  cin >> t;
  while (t--) {
    k = 0;
    map<long long, long long> mp, pm;
    cin >> n >> m;
    for (i = 0; i < n; i++) cin >> A[i];
    for (i = 0; i < m; i++) cin >> B[i], mp[B[i]]++;
    for (i = 0; i < n; i++)
      if (mp[A[i]]) break;
    if (i == n)
      cout << "NO" << endl;
    else
      cout << "YES" << endl << 1 << " " << A[i] << endl;
  }
  return 0;
}
