#include <bits/stdc++.h>
using namespace std;
bool ab[100000000];
int ab1[1000000];
int ab2[1000000];
int v1[1000000];
int v2[1000000];
map<unsigned long long int, unsigned long long int> m;
map<unsigned long long int, unsigned long long int> m1;
map<unsigned long long int, unsigned long long int> m2;
vector<unsigned long long int>::iterator itr;
int main() {
  string s12;
  int a, b, d = 10000000, j = 0, i = 0, t, s = 0, s2, as, as1, n = 50, c = 0,
            c2 = 0, l;
  cin >> t;
  s = t;
  for (i = 0; i < s; i++) {
    cin >> a >> b;
    v1[i] = a;
    v2[i] = b;
  }
  for (i = 0; i < s; i++) {
    for (j = 0; j < s; j++)
      if (v2[i] == v1[j]) c++;
    if (v1[i] == v2[j]) c++;
  }
  cout << c << endl;
}
