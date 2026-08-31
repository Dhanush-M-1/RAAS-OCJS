#include <iostream>
#include <vector>
#include <limits>

uint32_t test_count;

uint32_t mono_count;
uint32_t poly_count;
uint32_t lines_count;

std::vector<uint32_t> mono_actions;
std::vector<uint32_t> poly_actions;
std::vector<uint32_t> team_actions;

void read() {
    std::ios_base::sync_with_stdio(false);
    std::cin >> test_count;
}

void prepare_test() {
    std::cin >> lines_count >> mono_count >> poly_count;
    
    mono_actions.clear();
    poly_actions.clear();
    team_actions.clear();
    
    mono_actions.resize(mono_count + 1u);
    poly_actions.resize(poly_count + 1u);
    
    mono_actions[mono_count] = std::numeric_limits<uint32_t>::max();
    for (uint32_t i = 0; i < mono_count; ++i)
        std::cin >> mono_actions[i];
        
    poly_actions[poly_count] = std::numeric_limits<uint32_t>::max();
    for (uint32_t i = 0; i < poly_count; ++i)
        std::cin >> poly_actions[i];
}

void solve() {
    uint32_t mono_iter = 0;
    uint32_t poly_iter = 0;
    
    while (mono_iter != mono_count || poly_iter != poly_count) {
        if (!mono_actions[mono_iter]) {
            team_actions.emplace_back(mono_actions[mono_iter++]);
            ++lines_count;
            continue;
        }
        
        if (!poly_actions[poly_iter]) {
            team_actions.emplace_back(poly_actions[poly_iter++]);
            ++lines_count;
            continue;
        }
        
        if (mono_actions[mono_iter] <= lines_count) {
            team_actions.emplace_back(mono_actions[mono_iter++]);
            continue;
        }
        
        if (poly_actions[poly_iter] <= lines_count) {
            team_actions.emplace_back(poly_actions[poly_iter++]);
            continue;
        }
        
        std::cout << "-1" << std::endl;
        return;
    }
    
    for (auto& action: team_actions)
        std::cout << action << ' ';
        
    std::cout << std::endl;
}

int main() {
    read();
    
    while (test_count--) {
        prepare_test();
        solve();
    }
    
    return 0;
}