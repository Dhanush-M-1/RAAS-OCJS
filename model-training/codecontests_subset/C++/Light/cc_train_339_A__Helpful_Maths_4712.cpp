#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int a[50];
  int count = 0;
  for (int j = 0; j < s.length(); j += 2) {
    a[count] = s.at(j) - '0';
    count++;
  }
  for (int i = 0; i < count; i++)
    for (int j = i + 1; j < count; j++)
      if (a[j] < a[i]) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
      }
  for (int i = 0; i < count - 1; i++) cout << a[i] << '+';
  cout << a[count - 1] << endl;
}
