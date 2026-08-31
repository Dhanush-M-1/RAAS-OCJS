#include <bits/stdc++.h>
using namespace std;
void fl() { ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0); }
map<char, int> iin;
map<char, int> iout;
string lls(long long a) {
  stringstream ss;
  ss << a;
  string str = ss.str();
  return str;
}
long long sst(string s) {
  stringstream g(s);
  long long x = 0;
  g >> x;
  return x;
}
int main() {
  fl();
  int n;
  cin >> n;
  for (int i = 1; i < n; i++, cout << endl)
    for (int j = 1; j < n; j++) cout << ((i * j) / n) * 10 + (i * j) % n << " ";
  return 0;
}
