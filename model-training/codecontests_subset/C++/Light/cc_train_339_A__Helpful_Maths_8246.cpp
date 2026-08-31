#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  cin >> a;
  sort(a.begin(), a.end());
  for (int i = a.size() / 2; i < a.size() - 1; i++) cout << a[i] << "+";
  cout << a[a.size() - 1];
}
