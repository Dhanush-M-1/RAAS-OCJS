#include <bits/stdc++.h>
using namespace std;
const long long int N = 1e5 + 5;
const long long int M = 1e9 + 7;
queue<pair<long long int, long long int> > pq;
vector<long long int> v;
map<long long int, long long int> mpp;
set<pair<long long int, long long int> > st;
long long int a[N], h[N], indx[N][2];
long long int val[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long int n, l;
  cin >> n;
  string s;
  cin >> s;
  long long int a = 0;
  long long int b = 0;
  for (int i = int(0); i <= int(n - 1); i++) {
    if (s[i] == '8') a++;
  }
  long long int x = n / 11;
  if (a < x)
    cout << a;
  else
    cout << x;
}
