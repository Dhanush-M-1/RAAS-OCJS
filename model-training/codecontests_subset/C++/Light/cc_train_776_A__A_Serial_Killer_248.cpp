#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, d;
  map<string, int> a;
  cin >> s;
  cin >> d;
  a[s]++;
  a[d]++;
  int n;
  cin >> n;
  cout << s;
  cout << " ";
  cout << d;
  cout << "\n";
  while (n--) {
    cin >> s;
    cin >> d;
    a[s]++;
    a[d]++;
    a[s] = 0;
    map<string, int>::iterator itr;
    for (itr = a.begin(); itr != a.end(); itr++) {
      if (itr->second == 1) {
        cout << itr->first;
        cout << " ";
      }
    }
    cout << "\n";
  }
  return 0;
}
