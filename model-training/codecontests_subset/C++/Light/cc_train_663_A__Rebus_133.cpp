#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100500;
vector<long long> arr;
long long n;
string s;
bool is_digit(char h) { return '0' <= h && h <= '9'; }
void parse() {
  string t;
  for (int i = 0; i < (int)s.size(); ++i)
    if (s[i] != ' ') t += s[i];
  s = t;
  s = "+" + s;
  for (int i = 0; i < (int)s.size(); ++i) {
    if (s[i] == '?') arr.push_back(s[i - 1] == '+' ? 1 : -1);
  }
  int ptr = (int)s.size() - 1;
  while (is_digit(s[ptr])) ptr--;
  ptr++;
  while (ptr < (int)s.size()) n = n * 10 + s[ptr++] - '0';
}
int main() {
  getline(cin, s);
  long long maxval = 0;
  long long minval = 0;
  parse();
  for (int i = 0; i < (int)arr.size(); ++i) {
    if (arr[i] == 1) {
      minval += 1;
      maxval += n;
    } else {
      minval -= n;
      maxval -= 1;
    }
  }
  if (n > maxval || n < minval) {
    cout << "Impossible\n";
    return 0;
  }
  long long rem = n;
  for (int i = (int)arr.size() - 1; i >= 0; i--) {
    long long cur;
    if (arr[i] == 1) {
      minval -= 1;
      maxval -= n;
      cur = max(1ll, rem - maxval);
      rem -= cur;
      arr[i] = cur;
    } else {
      minval += n;
      maxval += 1;
      cur = max(1ll, minval - rem);
      rem += cur;
      arr[i] = -cur;
    }
  }
  cout << "Possible\n";
  for (int i = 0; i < (int)arr.size(); ++i) {
    if (arr[i] < 0)
      cout << " - " << -arr[i];
    else if (i)
      cout << " + " << arr[i];
    else
      cout << arr[i];
  }
  cout << " = " << n;
  return 0;
}
