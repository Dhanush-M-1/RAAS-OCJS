#include <set>
#include <iostream>
#include <utility>
#include <vector>

int main() {
    std::set< std::pair<char, int > > st;

    int n;
    std::cin >> n;

    for (int i = 0; i < n; ++i) {
        char c;
        int a;
        std::cin >> c >> a;

        st.insert(std::make_pair(c, a));
    }

    std::vector< char > cs({'S', 'H', 'C', 'D'});

    for (const auto &c: cs) {
        for (int i = 1; i <= 13; ++i) {
            if (st.count(std::make_pair(c, i)) == 0) {
                std::cout << c << " " << i << std::endl;
            }
        }
    }
}
