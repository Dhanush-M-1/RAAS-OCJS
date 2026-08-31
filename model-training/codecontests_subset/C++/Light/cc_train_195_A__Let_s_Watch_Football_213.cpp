#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 100;
const double PI = 3.14159;
vector<pair<int, int> > corner;
vector<int> v;
long long n, m, k, d, c, a, b, ans;
set<string> st;
string s;
bool flag;
set<string>::iterator it;
map<int, char> mp;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cin >> a >> b >> c;
  long long want = (a * c + b - 1) / b;
  long long l = 1, r = want;
  while (l <= r) {
    long long mid = (l + r) / 2;
    if ((want)*b >= (want - mid) * a) {
      ans = mid;
      r = mid - 1;
    } else
      l = mid + 1;
  }
  cout << ans;
  return 0;
}
