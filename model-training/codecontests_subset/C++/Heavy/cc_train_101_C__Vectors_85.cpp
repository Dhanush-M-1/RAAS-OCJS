#include <bits/stdc++.h>
using namespace std;
int IsMultiplyOverflow(long long multiplicant1, long long multiplicant2,
                       long long overflow_limit) {
  if (multiplicant2 == 0LL) return overflow_limit < 0LL;
  return multiplicant1 > overflow_limit / multiplicant2;
}
class BigInt {
 public:
  BigInt() : digits_(1, 0), is_non_negative_(1) {}
  BigInt(long long initial_value) {
    if (initial_value < 0LL) {
      is_non_negative_ = 0;
      initial_value *= -1LL;
    } else {
      is_non_negative_ = 1;
    }
    if (initial_value == 0) {
      digits_.push_back(0);
    }
    while (initial_value) {
      digits_.push_back(initial_value % (long long)kDigitSize);
      initial_value /= (long long)kDigitSize;
    }
  }
  BigInt(const string& initial_value) { ParseFromString(initial_value); }
  void ParseFromString(string initial_value) {
    *this = 0;
    this->is_non_negative_ = 1;
    int negative = 0;
    if (initial_value[0] == '-') {
      negative = 1;
      initial_value = initial_value.substr(1, initial_value.size());
    }
    assert(initial_value.size() > 0);
    for (int i = 0; i < (int)initial_value.size(); ++i) {
      assert(initial_value[i] >= '0' && initial_value[i] <= '9');
      long long value = initial_value[i] - '0';
      *this *= 10;
      *this += value;
    }
    if (negative) {
      this->is_non_negative_ = 0;
    }
    this->Normalize();
  }
  BigInt(const BigInt& that) {
    this->is_non_negative_ = that.is_non_negative_;
    this->digits_ = that.digits_;
  }
  ~BigInt() {}
  BigInt& operator=(const BigInt& that) {
    this->is_non_negative_ = that.is_non_negative_;
    this->digits_ = that.digits_;
    return *this;
  }
  int Size() const { return (int)digits_.size(); }
  long long ToLongLong() const {
    long long ret = 0LL;
    for (int i = Size() - 1; i >= 0; --i) {
      assert(!IsMultiplyOverflow(ret, kDigitSize, 9223372036854775807));
      ret *= (long long)kDigitSize;
      ret += (long long)digits_[i];
    }
    if (!is_non_negative_) ret *= -1LL;
    return ret;
  }
  string ToString(int base = 10) const {
    assert(base >= 2);
    static string alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    assert(base <= (int)alphabet.size());
    BigInt this_copy = *this;
    if (this_copy == 0) return "0";
    vector<char> ret;
    int negative = 0;
    if (this_copy.is_non_negative_ == 0) {
      negative = 1;
      this_copy = this_copy.Absolute();
    }
    while (this_copy > 0) {
      ret.push_back(alphabet[(this_copy % base).ToLongLong()]);
      this_copy /= base;
    }
    reverse(ret.begin(), ret.end());
    string ret_value = "";
    for (size_t i = 0; i < ret.size(); ++i) {
      ret_value += ret[i];
    }
    if (negative) ret_value = "-" + ret_value;
    return ret_value;
  }
  bool operator==(const BigInt& that) const {
    return this->is_non_negative_ == that.is_non_negative_ &&
           this->digits_ == that.digits_;
  }
  bool operator!=(const BigInt& that) const { return !this->operator==(that); }
  BigInt Absolute() const {
    BigInt copy_of_this(*this);
    copy_of_this.is_non_negative_ = 1;
    return copy_of_this;
  }
  BigInt AntiAbsolute() const {
    BigInt copy_of_this(*this);
    if (*this == 0LL) return copy_of_this;
    copy_of_this.is_non_negative_ = 0;
    return copy_of_this;
  }
  BigInt operator-() const {
    BigInt copy_of_this(*this);
    copy_of_this.is_non_negative_ ^= 1;
    copy_of_this.Normalize();
    return copy_of_this;
  }
  bool operator<(const BigInt& that) const {
    if (!this->is_non_negative_) {
      if (that.is_non_negative_) {
        return true;
      } else {
        return that < this->Absolute();
      }
    } else {
      if (!that.is_non_negative_) {
        return false;
      }
      if (this->Size() != that.Size()) {
        return this->Size() < that.Size();
      }
      for (int i = this->Size() - 1; i >= 0; --i) {
        if (this->digits_[i] < that.digits_[i]) return true;
        if (this->digits_[i] > that.digits_[i]) return false;
      }
      return false;
    }
  }
  bool operator>(const BigInt& that) const { return that < *this; }
  bool operator<=(const BigInt& that) const {
    return *this == that || *this < that;
  }
  bool operator>=(const BigInt& that) const {
    return *this == that || *this > that;
  }
  BigInt operator+(const BigInt& that) const {
    if (this->is_non_negative_ != that.is_non_negative_) {
      if (this->is_non_negative_)
        return *this - that.Absolute();
      else
        return that - this->Absolute();
    }
    BigInt ret = 0LL;
    ret.is_non_negative_ = this->is_non_negative_;
    ret.digits_.clear();
    int carry = 0;
    for (int i = 0; carry || (i < max(this->Size(), that.Size())); ++i) {
      int left = 0;
      if (this->Size() > i) left = this->digits_[i];
      int right = 0;
      if (that.Size() > i) right = that.digits_[i];
      int sum = left + right + carry;
      ret.digits_.push_back(sum % kDigitSize);
      carry = sum / kDigitSize;
    }
    ret.Normalize();
    return ret;
  }
  BigInt operator-(const BigInt& that) const {
    if (this->is_non_negative_ != that.is_non_negative_) {
      BigInt copy_of_that(that);
      copy_of_that.is_non_negative_ ^= 1;
      return *this + copy_of_that;
    }
    if (!this->is_non_negative_) {
      return that.Absolute() - this->Absolute();
    }
    if (that > *this) {
      BigInt ret = that - *this;
      return ret.AntiAbsolute();
    }
    assert(this->Size() >= that.Size());
    int borrow = 0;
    BigInt ret;
    ret.digits_.clear();
    for (int i = 0; i < this->Size(); ++i) {
      int left = this->digits_[i];
      int right = 0;
      if (that.Size() > i) right = that.digits_[i];
      int sum = left - right - borrow;
      borrow = 0;
      while (sum < 0) {
        ++borrow;
        sum += kDigitSize;
      }
      ret.digits_.push_back(sum);
    }
    assert(borrow == 0);
    ret.Normalize();
    return ret;
  }
  BigInt& operator+=(const BigInt& that) { return operator=(*this + that); }
  BigInt& operator-=(const BigInt& that) { return operator=(*this - that); }
  BigInt& operator++() { return this->operator+=(1); }
  BigInt operator++(int) {
    BigInt ret(*this);
    ++(*this);
    return ret;
  }
  BigInt& operator--() { return this->operator-=(1); }
  BigInt operator--(int) {
    BigInt ret(*this);
    --(*this);
    return ret;
  }
  BigInt operator<<(const BigInt& that) const {
    assert(this->is_non_negative_);
    long long amount = that.ToLongLong();
    assert(amount >= 0LL);
    long long shift_digit = amount / kDigitSizeLog;
    vector<int> shifted_digits(shift_digit, 0);
    BigInt ret(*this);
    ret.digits_.insert(ret.digits_.begin(), shifted_digits.begin(),
                       shifted_digits.end());
    ret.Normalize();
    return ret.SlowMultiplication(1 << (amount % kDigitSizeLog));
  }
  BigInt& operator<<=(const BigInt& that) {
    return this->operator=(*this << that);
  }
  BigInt operator>>(const BigInt& that) const {
    assert(this->is_non_negative_);
    long long amount = that.ToLongLong();
    assert(amount >= 0LL);
    long long shift_digit = amount / kDigitSizeLog;
    if (this->Size() <= shift_digit) return 0;
    BigInt this_copy(*this);
    this_copy.digits_.erase(this_copy.digits_.begin(),
                            this_copy.digits_.begin() + shift_digit);
    long long remain = amount % kDigitSizeLog;
    int carry = 0;
    for (int i = this_copy.Size() - 1; i >= 0; --i) {
      this_copy.digits_[i] += (carry << kDigitSizeLog);
      carry = this_copy.digits_[i] % (1 << remain);
      this_copy.digits_[i] >>= remain;
    }
    this_copy.Normalize();
    return this_copy;
  }
  BigInt& operator>>=(const BigInt& that) {
    return this->operator=(*this >> that);
  }
  BigInt SlowMultiplication(const BigInt& that) const {
    if (that.Size() < this->Size()) {
      return that.SlowMultiplication(*this);
    }
    BigInt ret;
    ret.digits_ = vector<int>(this->Size() + that.Size());
    ret.is_non_negative_ = !(this->is_non_negative_ ^ that.is_non_negative_);
    for (int i = 0; i < this->Size(); ++i) {
      int carry = 0;
      int inner_carry = 0;
      for (int j = 0; j < that.Size(); ++j) {
        int mult = this->digits_[i] * that.digits_[j] + carry;
        ret.digits_[i + j] += mult % kDigitSize;
        carry = mult / kDigitSize;
        ret.digits_[i + j] += inner_carry;
        inner_carry = ret.digits_[i + j] / kDigitSize;
        ret.digits_[i + j] %= kDigitSize;
      }
      ret.digits_[i + that.Size()] += carry + inner_carry;
      int position = i + that.Size();
      while (ret.digits_[position] >= kDigitSize) {
        ret.digits_[position + 1] += ret.digits_[position] / kDigitSize;
        ret.digits_[position] %= kDigitSize;
        ++position;
      }
    }
    ret.Normalize();
    return ret;
  }
  BigInt operator*(const BigInt& that) const {
    if (that.Size() < this->Size()) {
      return that * *this;
    }
    if (this->Size() <= 4 ||
        this->Size() * that.Size() <= (int)floor(pow(that.Size(), 1.6)) / 16) {
      return this->SlowMultiplication(that);
    } else {
      int digitviding_line = (that.Size() + 1) / 2;
      BigInt xlarge, xsmall;
      BigInt ylarge, ysmall;
      xlarge.digits_.clear();
      xlarge.is_non_negative_ = true;
      xsmall.digits_.clear();
      xsmall.is_non_negative_ = true;
      ylarge.digits_.clear();
      ylarge.is_non_negative_ = true;
      ysmall.digits_.clear();
      ysmall.is_non_negative_ = true;
      for (int i = 0; i < digitviding_line; ++i) {
        int xsmallbit = 0;
        int xlargebit = 0;
        int ysmallbit = 0;
        int ylargebit = 0;
        if (this->Size() > i) xsmallbit = this->digits_[i];
        if (this->Size() > i + digitviding_line)
          xlargebit = this->digits_[i + digitviding_line];
        if (that.Size() > i) ysmallbit = that.digits_[i];
        if (that.Size() > i + digitviding_line)
          ylargebit = that.digits_[i + digitviding_line];
        xsmall.digits_.push_back(xsmallbit);
        xlarge.digits_.push_back(xlargebit);
        ysmall.digits_.push_back(ysmallbit);
        ylarge.digits_.push_back(ylargebit);
      }
      xsmall.Normalize();
      xlarge.Normalize();
      ysmall.Normalize();
      ylarge.Normalize();
      BigInt biggest = xlarge * ylarge;
      BigInt smallest = xsmall * ysmall;
      BigInt avg = ((xsmall + xlarge) * (ysmall + ylarge)) - biggest - smallest;
      biggest <<= (long long)digitviding_line * 2 * kDigitSizeLog;
      avg <<= (long long)digitviding_line * kDigitSizeLog;
      BigInt result = biggest + avg + smallest;
      result.is_non_negative_ =
          !(this->is_non_negative_ ^ that.is_non_negative_);
      result.Normalize();
      return result;
    }
  }
  BigInt& operator*=(const BigInt& that) {
    return this->operator=(*this * that);
  }
  BigInt operator/(const BigInt& that) const {
    int max_add = 0;
    BigInt that_copy(that.Absolute());
    BigInt this_copy(this->Absolute());
    while (that_copy <= this_copy) {
      ++max_add;
      that_copy <<= 1;
    }
    if (max_add == 0) {
      return 0;
    }
    BigInt ret;
    ret.digits_ = vector<int>(1 + max_add / kDigitSizeLog);
    ret.is_non_negative_ = !(this->is_non_negative_ ^ that.is_non_negative_);
    for (int i = max_add - 1; i >= 0; --i) {
      that_copy >>= 1;
      if (this_copy >= that_copy) {
        int digit_position = i / kDigitSizeLog;
        int digit_offset = i % kDigitSizeLog;
        ret.digits_[digit_position] += (1 << digit_offset);
        this_copy -= that_copy;
      }
    }
    ret.Normalize();
    return ret;
  }
  BigInt operator%(const BigInt& that) const {
    assert(that.is_non_negative_);
    assert(this->is_non_negative_);
    assert(that != 0);
    return *this - ((*this / that) * that);
  }
  BigInt& operator/=(const BigInt& that) {
    return this->operator=(*this / that);
  }
  BigInt& operator%=(const BigInt& that) {
    return this->operator=(*this % that);
  }
  friend ostream& operator<<(ostream& out, BigInt& obj) {
    out << obj.ToString();
    return out;
  }
  friend istream& operator>>(istream& in, BigInt& obj) {
    string rep;
    in >> rep;
    obj.ParseFromString(rep);
    return in;
  }

 private:
  void Normalize() {
    while (this->Size() > 1 && digits_.back() == 0) {
      digits_.pop_back();
    }
    if (this->Size() == 1 && this->digits_[0] == 0) {
      is_non_negative_ = 1;
    }
  }
  static const int kDigitSize = (1 << 15);
  static const int kDigitSizeLog = 15;
  vector<int> digits_;
  int is_non_negative_;
};
pair<BigInt, BigInt> transform(const pair<BigInt, BigInt>& org, BigInt dir) {
  if (dir == 0) {
    return org;
  } else if (dir == 1) {
    return make_pair(org.second, -(org.first));
  } else if (dir == 2) {
    return make_pair(-(org.first), -(org.second));
  } else {
    return make_pair(-(org.second), org.first);
  }
}
BigInt dir1[] = {0, 0, 2, 2};
BigInt dir2[] = {1, 3, 1, 3};
void ok() {
  cout << "YES" << endl;
  exit(0);
}
BigInt GreatestCommonDivisor(BigInt abc, BigInt def) {
  if (abc < 0LL || def < 0LL)
    return GreatestCommonDivisor(abc.Absolute(), def.Absolute());
  if (abc < def) return GreatestCommonDivisor(def, abc);
  if (def == 0) return abc;
  return GreatestCommonDivisor(def, abc % def);
}
int solve(BigInt x1, BigInt x2, BigInt x3) {
  return x3 % GreatestCommonDivisor(x1, x2) == 0LL;
}
int main() {
  pair<BigInt, BigInt> a;
  cin >> a.first >> a.second;
  pair<BigInt, BigInt> t;
  cin >> t.first >> t.second;
  pair<BigInt, BigInt> b;
  cin >> b.first >> b.second;
  for (int(i) = 0; (i) < (4); ++(i)) {
    pair<BigInt, BigInt> trans = transform(a, i);
    pair<BigInt, BigInt> target =
        make_pair(t.first - trans.first, t.second - trans.second);
    if (target.first == 0 && target.second == 0) {
      cout << "YES" << endl;
      return 0;
    }
    if (b.first == 0 && b.second == 0) {
      continue;
    }
    for (int(j) = 0; (j) < (4); ++(j)) {
      BigInt d1 = dir1[j];
      BigInt d2 = dir2[j];
      pair<BigInt, BigInt> trans1, trans2;
      trans1 = transform(b, d1);
      trans2 = transform(b, d2);
      BigInt x1 = trans1.first;
      BigInt y1 = trans1.second;
      BigInt x2 = trans2.first;
      BigInt y2 = trans2.second;
      BigInt x3 = target.first;
      BigInt y3 = target.second;
      if (x1 == 0LL && x2 == 0LL && x3 != 0LL) continue;
      if (y1 == 0LL && y2 == 0LL && y3 != 0LL) continue;
      if (x1 == 0LL && x2 == 0LL && x3 == 0LL) {
        if (solve(y1, y2, y3)) ok();
      } else if (y1 == 0LL && y2 == 0LL && y3 == 0LL) {
        if (solve(x1, x2, x3)) ok();
      } else {
        BigInt gcdx = GreatestCommonDivisor(x1, GreatestCommonDivisor(x2, x3));
        BigInt gcdy = GreatestCommonDivisor(y1, GreatestCommonDivisor(y2, y3));
        x1 /= gcdx;
        x2 /= gcdx;
        x3 /= gcdx;
        y1 /= gcdy;
        y2 /= gcdy;
        y3 /= gcdy;
        BigInt det = x1 * y2 - x2 * y1;
        if (det == 0LL) {
          if (solve(x1, x2, x3) && solve(y1, y2, y3)) ok();
          continue;
        }
        BigInt xnum = x2 * y3 - x3 * y2;
        BigInt xden = x2 * y1 - x1 * y2;
        if (xnum.Absolute() % xden.Absolute() != 0LL) continue;
        BigInt ynum = x1 * y3 - x3 * y1;
        if (ynum.Absolute() % xden.Absolute() != 0LL) continue;
        ok();
      }
    }
  }
  cout << "NO\n";
  return 0;
}
