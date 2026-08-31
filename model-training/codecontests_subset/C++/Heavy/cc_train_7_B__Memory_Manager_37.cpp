#include <bits/stdc++.h>
using namespace std;
namespace teorNum {
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
template <typename num>
int sign(num n) {
  return n >= 0 ? 1 : -1;
}
}  // namespace teorNum
namespace geom {
inline bool doubleEqual(double a, double b, double eps = 0.001) {
  return abs(a / b - 1) <= eps;
}
const double pi = std::atan(1.0f) * 4;
class vec {
 public:
  vec() = default;
  vec(int len) : data(len){};
  vec(double x, double y) : data({x, y}){};
  vec(double x, double y, double z) : data({x, y, z}){};
  vec(const vec& temp) : data(temp.data) {}
  vec(const std::initializer_list<double>& list) {
    for (auto& element : list) data.push_back(element);
  }
  friend const vec& operator+(const vec& left);
  friend const vec operator-(const vec& left);
  friend vec& operator+=(vec& left, const vec& right);
  friend vec& operator-=(vec& left, const vec& right);
  friend vec& operator*=(vec& left, const double right);
  friend vec& operator/=(vec& left, const double right);
  friend bool operator==(const vec& left, const vec& right);
  friend bool operator!=(const vec& left, const vec& right);
  double& operator[](int i) { return data[i]; };
  const double& operator[](int i) const { return data[i]; };
  vec& operator=(const vec& right) {
    data = right.data;
    return *this;
  };
  friend const vec operator+(const vec& left, const vec& right);
  friend const vec operator-(const vec& left, const vec& right);
  friend const vec operator*(const vec& left, const double right);
  friend const vec operator*(const double left, const vec& right);
  friend const vec operator/(const vec& left, const double right);
  friend const vec operator/(const double left, const vec& right);
  friend ostream& operator<<(ostream& out, const vec& a);
  friend istream& operator>>(istream& in, vec& a);
  int size() const { return data.size(); };
  double length() const {
    double sum = 0;
    for (int i = 0; i < size(); ++i) sum += (data[i] * data[i]);
    return sqrt(sum);
  }
  double scalarMupltiply(const vec& right) const {
    double ans = 0;
    for (int i = 0; i < size(); ++i) ans += (data[i] * right[i]);
    return ans;
  }
  const vec vectorMultiply(const vec& right) const {
    if (size() != right.size()) throw "Different sizes";
    if (size() < 2 || size() > 3) throw "Wrong size";
    vec a(3), b(3);
    if (size() == 2) {
      a = {data[0], data[1], 0};
      b = {right[0], right[1], 0};
    } else {
      a = *this;
      b = right;
    }
    vec ans(3);
    ans = {a[1] * b[2] - a[2] * b[1], -a[0] * b[2] + a[2] * b[0],
           a[0] * b[1] - a[1] * b[0]};
    return ans;
  }
  double angle() { return acos(scalarMupltiply({1, 0}) / length()); };
  double angleBetweenVectors(const vec& b) {
    return acos(scalarMupltiply(b) / b.length() / length());
  };
  const vec rotate(double angle) {
    return {data[0] * cos(angle) - data[1] * sin(angle),
            data[0] * sin(angle) + data[1] * cos(angle)};
  };

 private:
  vector<double> data;
};
const vec& operator+(const vec& left) { return left; };
const vec operator-(const vec& left) {
  vec temp(left);
  return temp *= -1;
};
vec& operator+=(vec& left, const vec& right) {
  if (left.size() != right.size()) throw "Different sizes";
  for (int i = 0; i < left.size(); ++i) left[i] += right[i];
  return left;
}
vec& operator-=(vec& left, const vec& right) { return left += (-right); };
vec& operator*=(vec& left, const double right) {
  for (int i = 0; i < left.size(); ++i) left[i] *= right;
  return left;
}
vec& operator/=(vec& left, const double right) {
  for (int i = 0; i < left.size(); ++i) left[i] /= right;
  return left;
}
bool operator==(const vec& left, const vec& right) {
  for (int i = 0; i < left.size(); ++i)
    if (!doubleEqual(left[i], right[i])) return 0;
  return 1;
};
bool operator!=(const vec& left, const vec& right) { return !(left == right); }
const vec operator+(const vec& left, const vec& right) {
  vec temp = left;
  return temp += right;
}
const vec operator-(const vec& left, const vec& right) {
  return left + (-right);
}
const vec operator*(const vec& left, const double right) {
  vec temp = left;
  return temp *= right;
}
const vec operator*(const double left, const vec& right) {
  vec temp = right;
  return temp *= left;
}
const vec operator/(const vec& left, const double right) {
  vec temp = left;
  return temp /= right;
}
const vec operator/(const double left, const vec& right) {
  vec temp = right;
  return temp *= left;
}
ostream& operator<<(ostream& out, const vec& a) {
  for (int i = 0; i < a.size(); ++i) out << a[i] << " ";
  return out;
}
istream& operator>>(istream& in, vec& a) {
  for (int i = 0; i < a.size(); ++i) in >> a[i];
  return in;
}
double square(const std::initializer_list<vec>& list) {
  vec ans((list.end() - 1)->vectorMultiply(*list.begin()));
  for (auto iter = list.begin(); iter != list.end() - 1; ++iter)
    ans += (*iter).vectorMultiply(*(iter + 1));
  return ans.length() / 2;
}
}  // namespace geom
using namespace geom;
using namespace teorNum;
void solution() {
  long long t, m;
  cin >> t >> m;
  vector<long long> memory(m + 1, 0);
  memory[0] = 1;
  long long historyCount = 0;
  vector<long long> history(t + 2, -1);
  vector<long long> historyLen(t + 2, -1);
  for (int i = 0; i < t; ++i) {
    string command;
    cin >> command;
    if (command == "defragment") {
      long long start = 1;
      for (int i1 = 1; i1 <= m; ++i1) {
        int i2 = 1;
        if (memory[i1] == 1) {
          for (i2 = 1; i2 <= t; ++i2) {
            if (history[i2] == i1) break;
          }
          for (int i3 = 0; i3 < historyLen[i2]; ++i3) {
            swap(memory[i3 + start], memory[history[i2] + i3]);
          }
          history[i2] = start;
          start += historyLen[i2];
          i1 = start - 1;
        }
      }
      continue;
    }
    long long count;
    cin >> count;
    if (command == "alloc") {
      long long start = 1;
      int i1 = 1;
      for (i1 = 1; i1 <= m; ++i1) {
        if (memory[i1] == 0 && memory[i1 - 1] == 1) start = i1;
        if (memory[i1] == 0 && i1 - start + 1 >= count) {
          for (int i3 = start; i3 < start + count; ++i3) memory[i3] = 1;
          history[++historyCount] = start;
          historyLen[historyCount] = count;
          cout << historyCount << endl;
          break;
        }
        if (memory[i1] == 1) {
          start = 1000;
        }
      }
      if (i1 == m + 1) cout << "NULL" << endl;
    }
    if (command == "erase") {
      if (count < 1 || count >= t) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        continue;
      }
      if (history[count] == -1) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        continue;
      } else {
        for (int i1 = history[count]; i1 < history[count] + historyLen[count];
             ++i1) {
          memory[i1] = 0;
        }
        history[count] = -1;
        historyLen[count] = -1;
      }
    }
  }
}
int main() { solution(); }
