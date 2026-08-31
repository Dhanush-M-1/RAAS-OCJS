#include<iostream>
#include<vector>
#include<list>
#include<string>


using namespace std;


bool solve()
{
	int n; cin >> n;
	vector<string> w(n);

	if (n == 0)return false;

	for (int i = 0; i < n; ++i)
	{
		cin >> w[i];
	}

	for (int i = 0; i < w.size(); ++i)
	{
		list<int> mojisu{ 5,7,5,7,7 };
		for (int j = i; j < w.size(); ++j)
		{
			mojisu.front() -= (int)w[j].size();

			if (mojisu.front() == 0)
			{
				mojisu.pop_front();
				if (mojisu.empty())
				{
					cout << i+1 << endl;
					return true;
				}
			}
			else if (mojisu.front() < 0)
			{
				break;
			}

		}
	}
}


int main()
{
	while (solve())
	{
		
	}
}
