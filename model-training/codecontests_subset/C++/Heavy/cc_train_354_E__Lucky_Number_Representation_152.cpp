#include <bits/stdc++.h>
using namespace std;
const int oo = 0x3f3f3f3f;
const int LUCKY[3] = {0, 4, 7};
const int BASE = 10;
class State {
 public:
  State() : digits(), sum(0) {
    for (int i = 0; i < 6; ++i) digits[i] = 0;
  }
  State(int _digits[6]) : digits(), sum(0) {
    for (int i = 0; i < 6; ++i) sum += (digits[i] = _digits[i]);
  }
  int Units() const { return sum % BASE; }
  int Tens() const { return (sum / BASE) % BASE; }
  int Sum() const { return sum; }
  int GetDigit(const int index) const { return digits[index]; }
  void SetDigit(const int index, const int value) {
    sum -= digits[index];
    digits[index] = value;
    sum += digits[index];
  }

 private:
  int digits[6], sum;
};
vector<State> Rules;
vector<int> Number, LuckyNumbers[6];
bool Solution;
void GenerateRules(const int n, State &state) {
  if (n == 6) {
    bool valid = true;
    for (const auto &r : Rules)
      if (r.Sum() == state.Sum()) valid = false;
    if (valid) Rules.push_back(state);
    return;
  }
  for (int i = 0; i < 3; ++i) {
    state.SetDigit(n, LUCKY[i]);
    GenerateRules(n + 1, state);
  }
}
void GenerateRules() {
  State state;
  GenerateRules(0, state);
}
void Solve() {
  int n = int(Number.size());
  vector<vector<int> > dp =
      vector<vector<int> >(n + 1, vector<int>(BASE, false));
  vector<vector<int> > father =
      vector<vector<int> >(n + 1, vector<int>(BASE, -1));
  dp[0][0] = true;
  for (int prefix = 0; prefix < n; ++prefix) {
    for (int last = 0; last < BASE; ++last) {
      if (!dp[prefix][last]) continue;
      for (int i = 0; i < int(Rules.size()); ++i) {
        State r = Rules[i];
        if ((last + r.Units()) % BASE != Number[prefix]) continue;
        dp[prefix + 1][r.Tens() + (last + r.Units()) / BASE] = true;
        father[prefix + 1][r.Tens() + (last + r.Units()) / BASE] = i;
      }
    }
  }
  if (!dp[n][0]) {
    Solution = false;
    return;
  }
  Solution = true;
  for (int i = 0; i < 6; ++i) LuckyNumbers[i] = vector<int>(n, 0);
  for (int prefix = n, last = 0; prefix > 0; --prefix) {
    State r = Rules[father[prefix][last]];
    for (int i = 0; i < 6; ++i) LuckyNumbers[i][prefix - 1] = r.GetDigit(i);
    last = (Number[prefix - 1] - r.Units() + BASE) % BASE;
  }
}
void Read() {
  string number;
  cin >> number;
  Number = vector<int>();
  for (int i = int(number.length()) - 1; i >= 0; --i)
    Number.push_back(int(number[i]) - int('0'));
}
void Print() {
  if (!Solution) {
    cout << "-1\n";
    return;
  }
  for (int i = 0; i < 6; ++i) {
    for (; int(LuckyNumbers[i].size()) > 1 && LuckyNumbers[i].back() == 0;
         LuckyNumbers[i].pop_back())
      ;
    for (int j = int(LuckyNumbers[i].size()) - 1; j >= 0; --j)
      cout << LuckyNumbers[i][j];
    cout << " ";
  }
  cout << "\n";
}
int main() {
  GenerateRules();
  int testCount;
  cin >> testCount;
  for (; testCount > 0; --testCount) {
    Read();
    Solve();
    Print();
  }
  return 0;
}
