#include "stdio.h"
#include "string.h"
#include <iostream>

using namespace std;

pair<int,int> maxw[555];
pair<int,int> minw[555];

long long int dp[500][10][2];
long long int dp2[500][10][2];

char a[555];
char b[555];

int aw[555];
int bw[555];

int main()
{
	int m;
	scanf("%s",a);
	scanf("%s",b);
	scanf("%d",&m);
	int l;
	l = strlen(b);
	int lw;
	lw = strlen(a);
	for(int i = 0; i < l; i++)
	{
		bw[i] = b[i] - '0';
		if(0 <= (i - l + lw))
		{
			aw[i] = a[i - l + lw] - '0';
		}
		else
		{
			aw[i] = 0;
		}
	}
	int flg = 0;
	maxw[0] = make_pair(3,bw[0] % m);
	if(aw[0] == 0)
	{
		minw[0] = make_pair(0,0);
	}
	else
	{
		minw[0] = make_pair(3,aw[0] % m);
		flg = 1;
	}
	for(int i = 1; i < l; i++)
	{
		if(maxw[i - 1].first == 3)
		{
			if(bw[i] > bw[i - 1])
			{
				maxw[i] = make_pair(2,(maxw[i - 1].second * 10 + bw[i]) % m);
			}
			else if(bw[i] < bw[i - 1])
			{
				maxw[i] = make_pair(1,(maxw[i - 1].second * 10 + bw[i]) % m);
			}
			else
			{
				maxw[i] = make_pair(-1,0);
			}
		}
		else if(maxw[i - 1].first == 2)
		{
			if(bw[i] < bw[i - 1])
			{
				maxw[i] = make_pair(1,(maxw[i - 1].second * 10 + bw[i]) % m);
			}
			else
			{
				maxw[i] = make_pair(-1,0);
			}
		}
		else if(maxw[i - 1].first == 1)
		{
			if(bw[i] > bw[i - 1])
			{
				maxw[i] = make_pair(2,(maxw[i - 1].second * 10 + bw[i]) % m);
			}
			else
			{
				maxw[i] = make_pair(-1,0);
			}
		}
		else
		{
			maxw[i] = make_pair(-1,0);
		}

		if(flg == 0)
		{
			if(aw[i] != 0)
			{
				minw[i] = make_pair(3,aw[i] % m);
				flg = 1;
			}
			else
			{
				minw[i] = make_pair(0,0);
			}
		}
		else
		{
			if(minw[i - 1].first == 3)
			{
				if(aw[i] > aw[i - 1])
				{
					minw[i] = make_pair(2,(minw[i - 1].second * 10 + aw[i]) % m);
				}
				else if(aw[i] < aw[i - 1])
				{
					minw[i] = make_pair(1,(minw[i - 1].second * 10 + aw[i]) % m);
				}
				else
				{
					minw[i] = make_pair(-1,0);
				}
			}
			else if(minw[i - 1].first == 2)
			{
				if(aw[i] < aw[i - 1])
				{
					minw[i] = make_pair(1,(minw[i - 1].second * 10 + aw[i]) % m);
				}
				else
				{
					minw[i] = make_pair(-1,0);
				}
			}
			else if(minw[i - 1].first == 1)
			{
				if(aw[i] > aw[i - 1])
				{
					minw[i] = make_pair(2,(minw[i - 1].second * 10 + aw[i]) % m);
				}
				else
				{
					minw[i] = make_pair(-1,0);
				}
			}
			else
			{
				minw[i] = make_pair(-1,0);
			}
		}
	}

	for(int i = 0; i < 500; i++)
	{
		for(int ii = 0; ii < 10; ii++)
		{
			dp[i][ii][0] = 0;
			dp[i][ii][1] = 0;
		}
	}

	int flh = 0;

	for(int i = 0; i < l; i++)
	{
		for(int j = 0; j < 500; j++)
		{
			for(int jj = 0; jj < 10; jj++)
			{
				dp2[j][jj][0] = 0;
				dp2[j][jj][1] = 0;
			}
		}
		for(int ii = 0; ii < 10; ii++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(ii > j)
				{
					for(int jj = 0; jj < m; jj++)
					{
						dp2[(jj * 10 + ii) % m][ii][1] += dp[jj][j][0];
					}
				}
				else if(ii < j)
				{
					for(int jj = 0; jj < m; jj++)
					{
						dp2[(jj * 10 + ii) % m][ii][0] += dp[jj][j][1];
					}
				}
			}
		}

		if(aw[i] != bw[i] && flh == 0)
		{
			flh = 1;
		}

		if(flh != 0)
		{
			if(flh != 1)
			{
				if(i == 0)
				{
					for(int j = aw[i] + 1; j < bw[i]; j++)
					{
						dp2[j % m][j][0]++;
						dp2[j % m][j][1]++;
					}
				}
				else if(maxw[i - 1].first == 3)
				{
					for(int j = 0; j < bw[i]; j++)
					{
						if(j > bw[i - 1])
						{
							dp2[(maxw[i - 1].second * 10 + j) % m][j][1]++;
						}
						else if(j < bw[i - 1])
						{
							dp2[(maxw[i - 1].second * 10 + j) % m][j][0]++;
						}
					}
				}
				else if(maxw[i - 1].first == 2)
				{
					for(int j = 0; j < bw[i]; j++)
					{
						if(j < bw[i - 1])
						{
							dp2[(maxw[i - 1].second * 10 + j) % m][j][0]++;
						}
					}
				}
				else if(maxw[i - 1].first == 1)
				{
					for(int j = 0; j < bw[i]; j++)
					{
						if(j > bw[i - 1])
						{
							dp2[(maxw[i - 1].second * 10 + j) % m][j][1]++;
						}
					}
				}

				if(i != 0)
				{
					if(minw[i - 1].first == 0)
					{
						if(i == l - 1)
						{
							for(int j = aw[i]; j < 10; j++)
							{
								dp2[j % m][j][0]++;
							}
						}
						else
						{
							for(int j = aw[i] + 1; j < 10; j++)
							{
								dp2[j % m][j][0]++;
								dp2[j % m][j][1]++;
							}
						}
					}
					else if(minw[i - 1].first == 3)
					{
						for(int j = aw[i] + 1; j < 10; j++)
						{
							if(j > aw[i - 1])
							{
								dp2[(minw[i - 1].second * 10 + j) % m][j][1]++;
							}
							else if(j < aw[i - 1])
							{
								dp2[(minw[i - 1].second * 10 + j) % m][j][0]++;
							}
						}
					}
					else if(minw[i - 1].first == 2)
					{
						for(int j = aw[i] + 1; j < 10; j++)
						{
							if(j < aw[i - 1])
							{
								dp2[(minw[i - 1].second * 10 + j) % m][j][0]++;
							}
						}
					}
					else if(minw[i - 1].first == 1)
					{
						for(int j = aw[i] + 1; j < 10; j++)
						{
							if(j > aw[i - 1])
							{
								dp2[(minw[i - 1].second * 10 + j) % m][j][1]++;
							}
						}
					}
				}
			}
			else
			{
				if(i == 0)
				{
					for(int j = aw[i] + 1; j < bw[i]; j++)
					{
						dp2[j % m][j][0]++;
						dp2[j % m][j][1]++;
					}
				}
				else if(maxw[i - 1].first == 3)
				{
					for(int j = aw[i] + 1; j < bw[i]; j++)
					{
						if(j > bw[i - 1])
						{
							dp2[(maxw[i - 1].second * 10 + j) % m][j][1]++;
						}
						else if(j < bw[i - 1])
						{
							dp2[(maxw[i - 1].second * 10 + j) % m][j][0]++;
						}
					}
				}
				else if(maxw[i - 1].first == 2)
				{
					for(int j = aw[i] + 1; j < bw[i]; j++)
					{
						if(j < bw[i - 1])
						{
							dp2[(maxw[i - 1].second * 10 + j) % m][j][0]++;
						}
					}
				}
				else if(maxw[i - 1].first == 1)
				{
					for(int j = aw[i] + 1; j < bw[i]; j++)
					{
						if(j > bw[i - 1])
						{
							dp2[(maxw[i - 1].second * 10 + j) % m][j][1]++;
						}
					}
				}
				/*
				if(i != 0)
				{
					if(minw[i - 1].first == 0)
					{
						if(i == l - 1)
						{
							for(int j = aw[i]; j < bw[i]; j++)
							{
								dp2[j % m][j][0]++;
							}
						}
						else
						{
							for(int j = aw[i] + 1; j < bw[i]; j++)
							{
								dp2[j % m][j][0]++;
								dp2[j % m][j][1]++;
							}
						}
					}
					else if(minw[i - 1].first == 3)
					{
						for(int j = aw[i] + 1; j < bw[i]; j++)
						{
							if(j > aw[i - 1])
							{
								dp2[(minw[i - 1].second * 10 + j) % m][j][1]++;
							}
							else if(j < aw[i - 1])
							{
								dp2[(minw[i - 1].second * 10 + j) % m][j][0]++;
							}
						}
					}
					else if(minw[i - 1].first == 2)
					{
						for(int j = aw[i] + 1; j < bw[i]; j++)
						{
							if(j < aw[i - 1])
							{
								dp2[(minw[i - 1].second * 10 + j) % m][j][0]++;
							}
						}
					}
					else if(minw[i - 1].first == 1)
					{
						for(int j = aw[i] + 1; j < bw[i]; j++)
						{
							if(j > aw[i - 1])
							{
								dp2[(minw[i - 1].second * 10 + j) % m][j][1]++;
							}
						}
					}
				}
				*/
			}

			flh++;
		}

		for(int j = 0; j < m; j++)
		{
			for(int jj = 0; jj < 10; jj++)
			{
				for(int jjj = 0; jjj < 2; jjj++)
				{
					dp[j][jj][jjj] = dp2[j][jj][jjj] % 10000;
				}
			}
		}
	}

	int all = 0;
	for(int i = 0; i < 10; i++)
	{
		all = (all + dp[0][i][0]) % 10000;
		all = (all + dp[0][i][1]) % 10000;
	}
	printf("%d\n",all);

	return 0;
}