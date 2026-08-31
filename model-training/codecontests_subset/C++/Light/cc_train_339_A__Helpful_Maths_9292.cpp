#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int i, j, arr[s.size() / 2 + 1];
  for (i = 0, j = 0; i < s.size(); i += 2, j++) arr[j] = s.at(i);
  sort(arr, arr + j);
  for (i = 0, j = 0; i < s.size(); i += 2, j++) s.at(i) = arr[j];
  cout << s;
  return 0;
}
