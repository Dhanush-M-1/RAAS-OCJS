#include <bits/stdc++.h>
using namespace std;
int main() {
  int count = 0, size;
  cin >> size;
  char c;
  vector<char> num;
  for (int i = 0; i < size; i++) {
    cin >> c;
    num.push_back(c);
  }
  for (int i = 0; i < num.size(); i++) {
    if (num[i] == '8') count++;
    if ((size / 11) < count) count = (size / 11);
  }
  cout << count << endl;
  return 0;
}
