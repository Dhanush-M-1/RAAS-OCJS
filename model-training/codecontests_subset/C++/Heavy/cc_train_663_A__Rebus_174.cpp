#include <bits/stdc++.h>
const int oo = INT_MAX;
const long long int OO = (1LL << 62);
using namespace std;
template <typename Iter>
std::ostream& _out(std::ostream& s, Iter b, Iter e) {
  s << "[";
  for (auto it = b; it != e; it++) s << (it == b ? "" : " ") << *it;
  s << "]";
  return s;
}
template <typename A, typename B>
std::ostream& operator<<(std::ostream& s, const std::pair<A, B>& p) {
  return s << "(" << p.first << "," << p.second << ")";
}
template <typename T>
std::ostream& operator<<(std::ostream& s, const std::vector<T>& c) {
  return _out(s, begin(c), end(c));
}
template <typename T>
std::ostream& operator<<(std::ostream& s, const std::set<T>& c) {
  return _out(s, begin(c), end(c));
}
template <typename A, typename B>
std::ostream& operator<<(std::ostream& s, const std::map<A, B>& c) {
  return _out(s, begin(c), end(c));
}
template <typename T>
void _dump(const char* s, T&& head) {
  std::cerr << s << "=" << head << std::endl;
}
template <typename T, typename... Args>
void _dump(const char* s, T&& head, Args&&... tail) {
  int c = 0;
  while (*s != ',' || c != 0) {
    if (*s == '(' || *s == '[' || *s == '{') c++;
    if (*s == ')' || *s == ']' || *s == '}') c--;
    std::cerr << *s++;
  }
  std::cerr << "=" << head << ", ";
  _dump(s + 1, tail...);
}
void RI() {}
template <typename... T>
void RI(int& head, T&... tail) {
  scanf("%d", &head);
  RI(tail...);
}
int ceil(int x, int y) { return x / y + (x % y != 0); }
int main() {
  string input;
  getline(cin, input);
  istringstream iss(input);
  vector<string> tokens;
  copy(istream_iterator<string>(iss), istream_iterator<string>(),
       back_inserter(tokens));
  int plus = 0, minus = 0;
  int ans = 0;
  int n = atoi(tokens.back().c_str());
  for (int i = 0; i < tokens.size(); ++i) {
    if (i == 0)
      plus++;
    else if (tokens[i - 1] == "+")
      plus++;
    else if (tokens[i - 1] == "-")
      minus++;
  }
  vector<int> pluses, minuses;
  do {
    fprintf(stderr, "%s:%d - ", __PRETTY_FUNCTION__, 74);
    _dump("plus", plus);
  } while (0);
  ;
  do {
    fprintf(stderr, "%s:%d - ", __PRETTY_FUNCTION__, 75);
    _dump("minus", minus);
  } while (0);
  ;
  if (ceil(minus + n, plus) > n or (minus > 0 and ceil(plus - n, minus) > n) or
      (minus == 0 and plus > n)) {
    cout << "Impossible\n";
    return 0;
  }
  cout << "Possible\n";
  if (plus - n >= minus) {
    pluses.insert(pluses.end(), plus, 1);
    if (minus) {
      minuses.insert(minuses.end(), minus, (plus - n) / minus);
      for (int i = 0; i < (plus - n) % minus; ++i) minuses[i]++;
    }
  } else {
    minuses.insert(minuses.end(), minus, 1);
    pluses.insert(pluses.end(), plus, (minus + n) / plus);
    for (int i = 0; i < (minus + n) % plus; ++i) pluses[i]++;
  }
  string output;
  for (int i = 0; i < tokens.size(); ++i) {
    string output_token = tokens[i];
    if (i == 0 or tokens[i - 1] == "+") {
      output_token = to_string(pluses.front());
      pluses.erase(pluses.begin());
    } else if (tokens[i - 1] == "-") {
      output_token = to_string(minuses.front());
      minuses.erase(minuses.begin());
    }
    output += (output_token + " ");
  }
  cout << output << "\n";
  return 0;
}
