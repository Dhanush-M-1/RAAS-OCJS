#include <bits/stdc++.h>
using namespace std;
bool logic(char x, char y) { return x > y; }
int main() {
  char s[100];
  cin >> s;
  vector<char> v;
  stack<char> st;
  int i = 0;
  while (s[i] != '\0') {
    if (s[i] == '+') {
      st.push(s[i]);
    } else if (s[i] >= 48 && s[i] <= 58) {
      v.push_back(s[i]);
    }
    i++;
  }
  sort(v.begin(), v.end(), logic);
  while (v.empty() == false) {
    cout << *(v.end() - 1);
    v.pop_back();
    if (v.size() > 0) {
      cout << "+";
    }
  }
}
