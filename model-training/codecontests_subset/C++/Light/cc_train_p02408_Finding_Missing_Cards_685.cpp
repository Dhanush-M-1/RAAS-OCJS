#include <iostream>
using namespace std;

int main()
{
    string suits = "SHCD";
    bool cards[4][13] = {};
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        char suit;
        int lank;
        cin >> suit >> lank;
        cards[suits.find(suit)][lank - 1] = true;
    }

    for (int s = 0; s < 4; s++)
    {
        for (int l = 0; l < 13; l++)
        {
            if (!cards[s][l])
            {
                cout << suits[s] << " " << l + 1 << "\n";
            }
        }
    }

    return 0;
}

