#include <bits/stdc++.h>
using namespace std;
string a;
int n;
int main() {
  cin >> a;
  cin >> n;
  for (int i = 0; i < a.size(); i++) {
    a[i] = tolower(a[i]);
    if (a[i] < 97 + n) a[i] = toupper(a[i]);
  }
  cout << a << endl;
}
