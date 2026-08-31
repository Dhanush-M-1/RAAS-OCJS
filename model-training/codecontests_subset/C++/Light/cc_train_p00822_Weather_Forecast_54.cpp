#include <iostream>
#include <vector>
#include <set>

using Bool = bool;
using Int = long long int;
template <class T>
using Vector = std::vector<T>;
template <class T>
using Set = std::set<T>;

constexpr Int L = 531441;  // 9^6
constexpr Int F = 4;       // [4, 0, 0, 0, 0, 0]
const Vector<Int> mask{
    0b1100110000000000,
    0b0110011000000000,
    0b0011001100000000,
    0b0000110011000000,
    0b0000011001100000,
    0b0000001100110000,
    0b0000000011001100,
    0b0000000001100110,
    0b0000000000110011,
};

Vector<Int> wet;

void init() {
    wet.assign(L, 0);
    for (Int b = 0; b < L; ++b) {
        {
            Int c = b;
            for (Int j = 0; j < 6; ++j) {
                wet[b] |= mask[c % 9];
                c /= 9;
            }
        }
    }
}

Bool solve() {
    Int n;
    std::cin >> n;
    if (n == 0) return false;

    Set<Int> pos, npos;
    pos.clear();
    pos.insert(F);

    for (Int q = 0; q < n; ++q) {
        Int req = 0;
        for (Int j = 0; j < 16; ++j) {
            Int b;
            std::cin >> b;
            req = (req << 1) + b;
        }

        npos.clear();
        for (Int p = 0; p < 9; ++p) {
            if (q == 0 && p != 4) continue;
            if (req & mask[p]) continue;

            for (Int b : pos) {
                if (q >= 6 &&
                    (wet[b] | mask[p]) != ((1 << 16) - 1)) continue;

                Int prev = b % 9;
                if (p / 3 != prev / 3 &&
                    p % 3 != prev % 3) continue;

                npos.insert((b * 9 + p) % L);
            }
        }

        std::swap(pos, npos);
    }

    std::cout << !pos.empty() << std::endl;
    return true;
}

int main() {
    init();
    while (solve()) {}
    return 0;
}

