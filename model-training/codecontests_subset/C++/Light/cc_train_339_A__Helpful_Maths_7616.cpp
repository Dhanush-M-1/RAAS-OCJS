#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int a;
  vector<int> mas;
  cin >> s;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] > 47 && s[i] < 58) {
      a = s[i];
      a = a - 48;
      mas.push_back(a);
    }
  }
  sort(mas.begin(), mas.end());
  for (int i = 0; i < mas.size() - 1; i++) cout << mas[i] << "+";
  cout << mas[mas.size() - 1];
  return 0;
}
