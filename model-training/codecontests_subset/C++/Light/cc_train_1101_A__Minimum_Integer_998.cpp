#include <bits/stdc++.h>
using namespace std;
vector<long long int> v;
set<long long int> s1;
set<long long int> s2;
vector<long long int> v1;
vector<long long int> v2;
vector<long long int> v3;
vector<long long int> v4;
vector<long long int> v5;
vector<pair<long long int, long long int> > v6;
vector<string> v7;
list<long long int> l;
int main() {
  long long int t;
  cin >> t;
  while (t-- > 0) {
    long long int x, y, z;
    cin >> x >> y >> z;
    long long int i = 1;
    if ((z * i) >= x && (z * i) <= y) {
      cout << (((y / z) + 1) * z) << endl;
    } else
      cout << z << endl;
  }
}
