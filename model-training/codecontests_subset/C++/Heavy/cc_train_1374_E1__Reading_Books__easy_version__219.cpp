#include <bits/stdc++.h>
using namespace std;
namespace IO {
const int BUFFER_SIZE = 1 << 15;
char input_buffer[BUFFER_SIZE];
size_t input_pos = 0, input_len = 0;
char output_buffer[BUFFER_SIZE];
int output_pos = 0;
char number_buffer[100];
uint8_t lookup[100];
void _update_input_buffer() {
  input_len = fread(input_buffer, sizeof(char), BUFFER_SIZE, stdin);
  input_pos = 0;
  if (input_len == 0) input_buffer[0] = EOF;
}
inline char next_char(bool advance = true) {
  if (input_pos >= input_len) _update_input_buffer();
  return input_buffer[advance ? input_pos++ : input_pos];
}
inline bool isspace(char c) {
  return (unsigned char)(c - '\t') < 5 || c == ' ';
}
inline void read_char(char &c) {
  while (isspace(next_char(false))) next_char();
  c = next_char();
}
template <typename T>
inline void read_int(T &number) {
  bool negative = false;
  number = 0;
  while (!isdigit(next_char(false)))
    if (next_char() == '-') negative = true;
  do {
    number = 10 * number + (next_char() - '0');
  } while (isdigit(next_char(false)));
  if (negative) number = -number;
}
template <typename T, typename... Args>
inline void read_int(T &number, Args &...args) {
  read_int(number);
  read_int(args...);
}
inline void read_str(string &str) {
  while (isspace(next_char(false))) next_char();
  str.clear();
  do {
    str += next_char();
  } while (!isspace(next_char(false)));
}
void _flush_output() {
  fwrite(output_buffer, sizeof(char), output_pos, stdout);
  output_pos = 0;
}
inline void write_char(char c) {
  if (output_pos == BUFFER_SIZE) _flush_output();
  output_buffer[output_pos++] = c;
}
template <typename T>
inline void write_int(T number, char after = '\0') {
  if (number < 0) {
    write_char('-');
    number = -number;
  }
  int length = 0;
  while (number >= 10) {
    uint8_t lookup_value = lookup[number % 100];
    number /= 100;
    number_buffer[length++] = char((lookup_value & 15) + '0');
    number_buffer[length++] = char((lookup_value >> 4) + '0');
  }
  if (number != 0 || length == 0) write_char(char(number + '0'));
  for (int i = length - 1; i >= 0; i--) write_char(number_buffer[i]);
  if (after) write_char(after);
}
inline void write_str(const string &str, char after = '\0') {
  for (char c : str) write_char(c);
  if (after) write_char(after);
}
void init() {
  bool exit_success = atexit(_flush_output) == 0;
  assert(exit_success);
  for (int i = 0; i < 100; i++) lookup[i] = uint8_t((i / 10 << 4) + i % 10);
}
}  // namespace IO
void solution() {
  IO::init();
  int n, m, k;
  IO::read_int(n, m, k);
  vector<pair<int, int>> both, a, b, non;
  both.push_back({0, 0});
  a = both;
  b = both;
  non = both;
  both.pop_back();
  for (int i = 1; i <= n; i++) {
    int t, x, y;
    IO::read_int(t, x, y);
    if (x && y)
      both.emplace_back(t, i);
    else if (x)
      a.emplace_back(t, i);
    else if (y)
      b.emplace_back(t, i);
    else
      non.emplace_back(t, i);
  }
  sort(both.begin(), both.end());
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(non.begin(), non.end());
  int sza = a.size() - 1, szb = b.size() - 1, szn = non.size() - 1;
  vector<int> sa(a.size()), sb(b.size()), sn(non.size());
  for (int i = 1; i < a.size(); i++) sa[i] = sa[i - 1] + a[i].first;
  for (int i = 1; i < b.size(); i++) sb[i] = sb[i - 1] + b[i].first;
  for (int i = 1; i < non.size(); i++) sn[i] = sn[i - 1] + non[i].first;
  int kz;
  auto check = [&](int val, int nums) {
    if (nums < 0) return pair<bool, int>{false, 0};
    int ita = upper_bound(a.begin(), a.end(), pair<int, int>{val, LONG_MAX}) -
              a.begin();
    ita--;
    int itb = upper_bound(b.begin(), b.end(), pair<int, int>{val, LONG_MAX}) -
              b.begin();
    itb--;
    int itn =
        upper_bound(non.begin(), non.end(), pair<int, int>{val, LONG_MAX}) -
        non.begin();
    itn--;
    int sum = 0;
    if (ita > kz) sum += sa[ita] - sa[kz];
    if (itb > kz) sum += sb[itb] - sb[kz];
    ita = max(0, ita - kz);
    itb = max(0, itb - kz);
    int use = ita + itb + itn;
    if (use < nums) return pair<bool, int>{false, 0};
    int excess = use - nums;
    sum += sn[itn] - val * excess;
    return pair<bool, int>{true, sum};
  };
  int sum_both = 0;
  tuple<int, int, int> ans = {LONG_MAX, -1, -1};
  for (int i = 0; i <= both.size(); i++) {
    if (i > 0) sum_both += both[i - 1].first;
    kz = max(0, k - i);
    if (kz > sza || kz > szb) continue;
    if (kz + kz + i > m) continue;
    if (i + sza + szb + szn < m) continue;
    int l = 1, r = 10000, pv = -1, temp = -1;
    while (l <= r) {
      int mid = (l + r) >> 1;
      pair<bool, int> ck = check(mid, m - kz * 2 - i);
      if (ck.first)
        r = mid - 1, pv = mid, temp = ck.second;
      else
        l = mid + 1;
    }
    if (pv == -1) continue;
    ans = min(ans, make_tuple(sum_both + sa[kz] + sb[kz] + temp, i, pv));
  }
  if (get<1>(ans) == -1)
    cout << -1;
  else {
    IO::write_int(get<0>(ans), '\n');
    for (int i = 0; i < get<1>(ans); i++) IO::write_int(both[i].second, ' ');
    kz = k - get<1>(ans);
    kz = max(0, kz);
    for (int i = 1; i <= kz; i++) {
      IO::write_int(a[i].second, ' ');
      IO::write_int(b[i].second, ' ');
    }
    vector<pair<int, int>> v;
    for (int i = kz + 1; i < a.size(); i++) v.push_back(a[i]);
    for (int i = kz + 1; i < b.size(); i++) v.push_back(b[i]);
    for (int i = 1; i < non.size(); i++) v.push_back(non[i]);
    sort(v.begin(), v.end());
    for (int i = 0; i < m - kz * 2 - get<1>(ans); i++)
      IO::write_int(v[i].second, ' ');
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int tc = 1;
  while (tc--) {
    solution();
  }
}
