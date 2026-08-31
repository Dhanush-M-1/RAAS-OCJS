#include <bits/stdc++.h>
using namespace std;
int main() {
  map<char, int> frequency;
  string text;
  int n;
  cin >> n;
  cin >> text;
  for (int i = 0; i < text.size(); i++) {
    if (frequency.find(text[i]) == frequency.end()) {
      frequency[text[i]] = 1;
    } else {
      frequency[text[i]] += 1;
    }
  }
  map<char, int>::iterator it = frequency.begin();
  string x("");
  bool error = false;
  while (it != frequency.end() && !error) {
    if (it->second % n != 0) {
      error = true;
    } else {
      for (int i = 0; i < it->second / n; i++) {
        x = x + it->first;
      }
    }
    it++;
  }
  if (error) {
    cout << "-1" << endl;
  } else {
    for (int i = 0; i < n; i++) {
      cout << x;
    }
    cout << endl;
  }
  return 0;
}
