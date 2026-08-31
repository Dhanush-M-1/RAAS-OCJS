#include <bits/stdc++.h>
using namespace std;
map<string, string> mymap;
vector<string> vec;
map<string, string>::iterator it;
string a[1000000];
int main() {
  string s1, s2, s3, s4, s5, s6;
  int k = 0;
  cin >> s1 >> s2;
  s5 = s1;
  s6 = s2;
  mymap[s1] = s2;
  mymap[s2] = s1;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> s1 >> s2;
    s4 = mymap[s1];
    a[k++] = s4;
    a[k++] = s2;
    s3 = mymap[s1];
    mymap[s3] = s2;
    mymap[s2] = s3;
  }
  cout << s5 << " " << s6 << endl;
  for (int i = 0; i < k; i += 2) {
    cout << a[i] << " " << a[i + 1] << endl;
  }
}
