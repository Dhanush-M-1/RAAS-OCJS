#include <bits/stdc++.h>
volatile bool isLocalTestEnabled = 0;
bool g_isLocalPrintEnabled = (bool)(0);
template <typename T>
void UpdateMin(T& a, const T b) {
  a = std::min(a, b);
}
template <typename T>
void UpdateMax(T& a, const T b) {
  a = std::max(a, b);
}
const long double Pi = std::atan(1.0L) * 4.0L;
static const long double Eps = 1.0e-09;
template <typename T>
bool IsEqual(const T a, const T b) {
  return std::abs(a - b) < Eps;
}
template <typename T>
bool IsGreater(const T a, const T b) {
  return a > b + Eps;
}
template <typename T>
bool IsLess(const T a, const T b) {
  return a + Eps < b;
}
template <typename T>
bool IsGreaterEqual(const T a, const T b) {
  return !IsLess(a, b);
}
template <typename T>
bool IsLessEqual(const T a, const T b) {
  return !IsGreater(a, b);
}
template <typename T>
std::string ToStr(const T& val) {
  std::ostringstream ostr;
  ostr << val;
  return ostr.str();
}
template <typename T>
bool FromStr(const std::string& str, T& val) {
  std::istringstream istr(str);
  istr >> val;
  return !!istr;
}
template <typename T>
std::istream& operator>>(std::istream& ist, std::vector<T>& data) {
  ;
  for (size_t i = 0; i < data.size(); i++) {
    ist >> data[i];
  }
  return ist;
}
template <typename T>
T Read(std::istream& ist) {
  ;
  T val;
  ist >> val;
  return val;
}
template <typename T>
std::ostream& operator<<(std::ostream& ost, const std::vector<T>& data) {
  for (size_t i = 0; i < data.size(); i++) {
    if (i != 0) {
      ost << ' ';
    }
    ost << data[i];
  }
  return ost;
}
template <size_t id>
class StopWatch {};
void Parse(const std::string& line, std::vector<int32_t>& signs, int64_t& sum) {
  signs.clear();
  signs.push_back(1);
  sum = 0;
  size_t i = 0;
  while (i < line.size()) {
    if (line[i] == '+') {
      signs.push_back(1);
    } else if (line[i] == '-') {
      signs.push_back(-1);
    } else if (line[i] == '=') {
      i++;
      break;
    }
    i++;
  }
  const bool isSumParsed = FromStr<int64_t>(line.substr(i), sum);
  ;
}
bool IsInRange(const int64_t v, const int64_t vMin, const int64_t vMax) {
  return (v >= vMin) && (v <= vMax);
}
bool TryFindSolution(const int64_t n, const int64_t pluses,
                     const int64_t minuses, const int64_t sum, int64_t& toAdd,
                     int64_t& toSubtract) {
  toAdd = pluses;
  toSubtract = minuses;
  const int64_t minPlus = pluses * 1;
  const int64_t maxPlus = pluses * n;
  const int64_t minMinus = minuses * 1;
  const int64_t maxMinus = minuses * n;
  if (IsInRange(minPlus - sum, minMinus, maxMinus)) {
    toAdd = minPlus;
    toSubtract = minPlus - sum;
    return true;
  }
  if (IsInRange(maxPlus - sum, minMinus, maxMinus)) {
    toAdd = maxPlus;
    toSubtract = maxPlus - sum;
    return true;
  }
  if (IsInRange(sum + minMinus, minPlus, maxPlus)) {
    toAdd = sum + minMinus;
    toSubtract = minMinus;
    return true;
  }
  return false;
}
std::vector<int64_t> ConstructSummands(const int64_t n, const int64_t count,
                                       const int64_t totalToAdd) {
  std::vector<int64_t> summands((size_t)count, 1);
  ;
  int64_t rem = totalToAdd - count;
  for (size_t i = 0; i < summands.size(); i++) {
    if (rem > 0) {
      const int64_t d = std::min(rem, n - 1);
      summands[i] += d;
      rem -= d;
    };
    ;
  };
  return summands;
}
std::string ConstructSolution(const int64_t n,
                              const std::vector<int32_t>& signs,
                              const int64_t pluses, const int64_t minuses,
                              const int64_t sum, const int64_t toAdd,
                              const int64_t toSubtract) {
  ;
  std::vector<int64_t> itemsToAdd = ConstructSummands(n, pluses, toAdd);
  std::vector<int64_t> itemsToSubtract =
      ConstructSummands(n, minuses, toSubtract);
  ;
  ;
  std::ostringstream ostr;
  size_t iAdd = 0;
  size_t iSubtract = 0;
  for (size_t i = 0; i < signs.size(); i++) {
    if (signs[i] == 1) {
      if (i != 0) {
        ostr << " + ";
      }
      ostr << itemsToAdd[iAdd];
      iAdd++;
    } else if (signs[i] == -1) {
      ;
      ostr << " - ";
      ostr << itemsToSubtract[iSubtract];
      iSubtract++;
    }
  }
  ostr << " = " << sum;
  return ostr.str();
}
bool Solve(std::istream& ist, std::ostream& ost, const bool multipleTestMode) {
  StopWatch<1> sw;
  (void)sw;
  std::string line;
  std::getline(ist, line);
  if (multipleTestMode && !ist) return false;
  if (!g_isLocalPrintEnabled) {
  } else
    std::cerr << std::endl << "Next test: " << line << std::endl;
  std::vector<int32_t> signs;
  int64_t n = 0;
  Parse(line, signs, n);
  ;
  const int64_t pluses = std::count(signs.begin(), signs.end(), 1);
  const int64_t minuses = std::count(signs.begin(), signs.end(), -1);
  int64_t toAdd;
  int64_t toSubtract;
  if (!TryFindSolution(n, pluses, minuses, n, toAdd, toSubtract)) {
    ost << "Impossible" << std::endl;
    return multipleTestMode;
  }
  const std::string solved =
      ConstructSolution(n, signs, pluses, minuses, n, toAdd, toSubtract);
  ost << "Possible" << std::endl;
  ost << solved << std::endl;
  ;
  return multipleTestMode;
}
int main(int argc, const char* argv[]) {
  std::ios_base::sync_with_stdio(false);
  std::istream* ist = &std::cin;
  std::ostream* ost = &std::cout;
  std::unique_ptr<std::istream> fileInput;
  if (argc > 1) {
    fileInput.reset(new std::ifstream(argv[1]));
    if (!(*fileInput)) {
      std::cout << "File not found: " << argv[1] << std::endl;
    }
    ist = fileInput.get();
  }
  Solve(*ist, *ost, false);
}
