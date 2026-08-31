#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  vector<string> tokens;
  stringstream stream(s);
  string temp;
  while (getline(stream, temp, '+')) {
    tokens.push_back(temp);
  }
  sort(tokens.begin(), tokens.end());
  temp = "";
  for (auto i = 0; i < tokens.size(); i++) {
    if (i != tokens.size() - 1)
      temp += tokens[i] + '+';
    else
      temp += tokens[i];
  }
  cout << temp << endl;
  return 0;
}
