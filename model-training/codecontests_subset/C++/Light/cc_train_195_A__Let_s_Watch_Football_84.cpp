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
  k = (a * c - c * b) / b;
  if ((a * c - c * b) % b != 0) k++;
  cout << k << endl;
  return 0;
}
