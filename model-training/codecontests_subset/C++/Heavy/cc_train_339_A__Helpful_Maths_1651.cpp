#include <bits/stdc++.h>
using namespace std;
void fast() {
  std::ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
}
const long long MOD = 1e9 + 7;
int main() {
  long long t = 1;
  while (t--) {
    string s;
    cin >> s;
    vector<long long> vc;
    long long siz = s.size();
    for (long long i = 0; i < siz; ++i) {
      if (s[i] >= '0' && s[i] <= '9') {
        vc.push_back(int(s[i] - 48));
      }
    }
    sort((vc).begin(), (vc).end());
    long long second = vc.size();
    for (long long i = 0; i < second; ++i) {
      if (i != second - 1)
        cout << vc[i] << '+';
      else
        cout << vc[i];
    }
    cout << '\n';
  }
}
