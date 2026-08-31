#include <iostream>
#include <string>
#include <cstring>
#define MOD 10000
using namespace std;

string a,b;
int M, dp[502][2][10][3][500], mod=10000, ans=0;
//dp[何桁目を見ているか][自由に選べるか][今の桁の数字][今で下がるか上がるか][今の桁までの余り]
//1で前より上がる、2で前より下がる、0で未変化
//0で自由に選べない、1で自由に選べる
//dp[0][][][][] is unused

int solve ()
{
    if (a=="0") return 0; //0なので最後で-1してはならない
    ans=0;
    memset(dp, 0, sizeof(dp));
    for (int i=0; i<=a[0]-'0'; i++)
    {
        if (i!=a[0]-'0') dp[1][1][i][0][i%M]=1;
        else dp[1][0][i][0][i%M]=1;
    }
    for (int i=1; i<a.size(); i++) //今何桁目を見ているか
    {
        //b=0 まだ自由には使えないので今の桁の数字はaの同じ桁の所の数字より小さいまたは同じでなければいけない
        for (int j=0; j<=a[i]-'0'; j++) //次の桁になれる数字（aを越えない）
        {
            for (int k=0; k<=a[i-1]-'0'; k++) //今の桁の数字としてありえる数（このセクションでは数字は自由に使えないので前の数字として全てが考えられるわけではない）
            {
                for (int l=0; l<3; l++) //今回上昇するか下降するかそのままか
                {
                    for (int m=0; m<M; m++) //今の桁までの余りとして考えられる数字
                    {
                        if (l==0) //前と比べて上下していない
                        {
                            if (k==0) //今の数字が0で今回も増減しないのでまだ桁がジグザグまで達していない
                            {
                                if (j==a[i]-'0') //次の桁で限界まで取るので自由に選べない
                                {
                                    //初めの桁なので増減していないとみなせる
                                    dp[i+1][0][j][0][(m*10+j)%M]+=dp[i][0][k][l][m]%mod;
                                }
                                else //今の桁で自由になる（限界まで取らない）
                                {
                                    dp[i+1][1][j][0][(m*10+j)%M]+=dp[i][0][k][l][m]%mod;
                                }
                            }
                            else //今の数字は0じゃない＝＝ジグザグはもう始まっている
                            {
                                if (j<k) //次の数字は今のよりも小さい
                                {
                                    if (j==a[i]-'0') dp[i+1][0][j][2][(m*10+j)%M]+=dp[i][0][k][l][m]%mod;
                                    else dp[i+1][1][j][2][(m*10+j)%M]+=dp[i][0][k][l][m]%mod;
                                }
                                //次と今が同じだったらアウトなのでパス
                                if (j>k) //次の数字は今のより大きい
                                {
                                    if (j==a[i]-'0') dp[i+1][0][j][1][(m*10+j)%M]+=dp[i][0][k][l][m]%mod;
                                    else dp[i+1][1][j][1][(m*10+j)%M]+=dp[i][0][k][l][m]%mod;
                                }
                            }
                        }
                        if (l==1) //今に至るときに増加したので次は減少
                        {
                            if (j<k)
                            {
                                if (j==a[i]-'0') dp[i+1][0][j][2][(m*10+j)%M]+=dp[i][0][k][l][m]%mod;
                                else dp[i+1][1][j][2][(m*10+j)%M]+=dp[i][0][k][l][m]%mod;
                            }
                        }
                        if (l==2) //今減少、次増加
                        {
                            if (j>k)
                            {
                                if (j==a[i]-'0') dp[i+1][0][j][1][(m*10+j)%M]+=dp[i][0][k][l][m]%mod;
                                else dp[i+1][1][j][1][(m*10+j)%M]+=dp[i][0][k][l][m]%mod;
                            }
                        }
                    }
                }
            }
        }
        //今回で自由に使えるようにする (b=1)
        for (int j=0; j<=9; j++) //自由なので次に使う数字は何でもいい
        {
            for (int k=0; k<=9; k++) //もし一つ前が自由じゃなかったとしてもそこには何も入っていないのでセーフ
            {
                for (int l=0; l<3; l++)
                {
                    for (int m=0; m<M; m++)
                    {
                        if (l==0)
                        {
                            if (k==0) dp[i+1][1][j][0][(m*10+j)%M]+=dp[i][1][k][l][m]%mod;
                            else
                            {
                                if (j<k) dp[i+1][1][j][2][(m*10+j)%M]+=dp[i][1][k][l][m]%mod;
                                if (j>k) dp[i+1][1][j][1][(m*10+j)%M]+=dp[i][1][k][l][m]%mod;
                            }
                        }
                        if (l==1)
                        {
                            if (j<k) dp[i+1][1][j][2][(m*10+j)%M]+=dp[i][1][k][l][m]%mod;
                        }
                        if (l==2)
                        {
                            if (j>k) dp[i+1][1][j][1][(m*10+j)%M]+=dp[i][1][k][l][m]%mod;
                        }
                    }
                }
            }
        }

    }
    for (int i=0; i<2; i++) for (int j=0; j<=9; j++) for (int k=0; k<3; k++) ans+=dp[a.size()][i][j][k][0];
    return (ans-1)%mod; //全て0の場合を引く
}

int main()
{
    cin>>a>>b>>M;
    int zig_a=0, zig_b=0;
    for (int i=a.size()-1; i>=0; i--)
    {
        if (a[i]>'0')
        {
            a[i]--;
            break;
        }
        else a[i]='9';
    }
    if (a[0]=='0' && a.size()!=1) a=a.substr(1,a.size()-1);
    zig_a=solve();
    a=b;
    zig_b=solve();
    cout<<(zig_b-zig_a+mod)%mod<<'\n';
    return 0;
}

