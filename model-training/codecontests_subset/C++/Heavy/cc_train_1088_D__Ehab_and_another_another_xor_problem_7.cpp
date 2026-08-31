#include <bits/stdc++.h>
using namespace std;
const int kMaxBits = 30;
enum class Result { Less, Equal, Greater };
struct Answer {
  Answer() = default;
  Answer(int a, int b) : m_a(a), m_b(b) {}
  int m_a = 0;
  int m_b = 0;
};
Result Ask(int c, int d) {
  cout << "? " << c << " " << d << endl;
  int result;
  cin >> result;
  if (result == -2) {
    cerr << "Number of guesses exceeded" << endl;
    exit(0);
  }
  if (result == -1) return Result::Less;
  if (result == 0) return Result::Equal;
  if (result == 1) return Result::Greater;
  cerr << "Unknown result: " << result << endl;
  exit(0);
}
Answer SolveEqual() {
  int answer = 0;
  for (int bit = 0; bit < kMaxBits; ++bit) {
    const auto result = Ask(1 << bit, 0);
    switch (result) {
      case Result::Less:
        answer = answer | (1 << bit);
        break;
      case Result::Equal:
        cerr << "Impossible" << endl;
        exit(0);
        break;
      case Result::Greater:
        break;
    }
  }
  return {answer, answer};
}
Answer Solve(Result curr) {
  int amask = 0;
  int bmask = 0;
  for (int bit = kMaxBits - 1; bit >= 0; --bit) {
    switch (curr) {
      case Result::Less: {
        const auto r10 = Ask(amask | (1 << bit), bmask);
        const auto r11 = Ask(amask | (1 << bit), bmask | (1 << bit));
        switch (r11) {
          case Result::Less:
            switch (r10) {
              case Result::Less:
                amask = amask | (1 << bit);
                bmask = bmask | (1 << bit);
                break;
              case Result::Equal:
                assert(false);
                break;
              case Result::Greater:
                break;
            }
            break;
          case Result::Equal:
            assert(false);
            break;
          case Result::Greater:
            bmask = bmask | (1 << bit);
            curr = r10;
            break;
        }
        break;
      }
      case Result::Equal: {
        switch (Ask(amask | (1 << bit), bmask)) {
          case Result::Less:
            amask = amask | (1 << bit);
            bmask = bmask | (1 << bit);
            break;
          case Result::Equal:
            assert(false);
            break;
          case Result::Greater:
            break;
        }
        curr = Result::Equal;
        break;
      }
      case Result::Greater: {
        const auto r10 = Ask(amask | (1 << bit), bmask);
        const auto r11 = Ask(amask | (1 << bit), bmask | (1 << bit));
        switch (r11) {
          case Result::Less:
            amask = amask | (1 << bit);
            curr = r10;
            break;
          case Result::Equal:
            assert(false);
            break;
          case Result::Greater:
            switch (r10) {
              case Result::Greater:
                break;
              case Result::Equal:
                assert(false);
                break;
              case Result::Less:
                amask = amask | (1 << bit);
                bmask = bmask | (1 << bit);
                break;
            }
        }
        break;
      }
    }
  }
  return {amask, bmask};
}
int main() {
  ios_base::sync_with_stdio(false);
  const auto answer = Solve(Ask(0, 0));
  cout << "! " << answer.m_a << " " << answer.m_b << endl;
  return 0;
}
