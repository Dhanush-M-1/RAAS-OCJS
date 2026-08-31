#include <bits/stdc++.h>
using namespace std;
set<string> ss;
string strA, strB;
int n;
int main() {
  cin >> strA >> strB;
  ss.insert(strA);
  ss.insert(strB);
  cin >> n;
  cout << strA << " " << strB << endl;
  for (int i = 1; i <= n; i++) {
    cin >> strA >> strB;
    ss.erase(strA);
    ss.insert(strB);
    set<string>::iterator itor = ss.begin();
    cout << *itor << " ";
    itor++;
    cout << *itor << endl;
  }
  return 0;
}
