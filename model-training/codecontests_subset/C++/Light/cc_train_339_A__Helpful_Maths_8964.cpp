#include <bits/stdc++.h>
using namespace std;
vector<int> arr;
void fill() {
  char ch = getchar();
  while (ch != '\n') {
    if (ch != '+') arr.push_back(ch - '0');
    ch = getchar();
  }
}
int main() {
  fill();
  sort(arr.begin(), arr.end());
  for (int i = 0; i < arr.size(); ++i) {
    cout << arr[i];
    if (i != arr.size() - 1) cout << "+";
  }
}
