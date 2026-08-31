#include <iostream>
#include <map>
using namespace std;

int main()
{
	map<char, int> CtoI;
	CtoI['S'] = 0;
	CtoI['H'] = 1;
	CtoI['C'] = 2;
	CtoI['D'] = 3;
	
	map<int, char> ItoC;
	ItoC[0] = 'S';
	ItoC[1] = 'H';
	ItoC[2] = 'C';
	ItoC[3] = 'D';
	
	int N, I;
	char C;
	bool card[52];
	
	for(int i = 0; i < 52; ++i)
	{
		card[i] = true;
	}
	
	cin >> N;
	for(int i = 0; i < N; ++i)
	{
		cin >> C >> I;
		card[CtoI[C] * 13 + I - 1] = false;
	}
	
	for(int i = 0; i < 52; ++i)
	{
		if(card[i])
		{
			cout << ItoC[i / 13] << " " << i % 13 + 1 << endl;
		}
	}

    return 0;
}

