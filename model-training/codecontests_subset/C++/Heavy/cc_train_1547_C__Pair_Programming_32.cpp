/**
    You just can't beat the one who never gives up

                            /T /I
                              / |/ | .-~/
                          T\ Y  I  |/  /  _
         /T               | \I  |  I  Y.-~/
        I l   /I       T\ |  |  l  |  T  /
     T\ |  \ Y l  /T   | \I  l   \ `  l Y
 __  | \l   \l  \I l __l  l   \   `  _. |
 \ -l  `\   `\  \  \ ~\  \   `. .-   |
  \   ~-. "-.  `  \  ^._ ^. "-.  /  \   |
.--~-._  ~-  `  _  ~-.-"-." . /._ ." ./
 >--.  ~-.   ._  ~>-"    "\   7   7   ]
^._"--._    ~-{  .- .  `\ Y . /    |
 <_ ~"-.  ~       //   \   \I  Y   : |
   ^-._           ~(/   \   >.:   | l___
       ^--.,_.-"  /_/   !  `-."--l_ /     ~"-.
              (_/ .  (   /'     ""--,Y   -=b-. _)
               (_/ .  \  :           / l      c"~o \
                \ /    `.    .     .^   \_.-"--.  )
                 (_/ .   `  /     /       !       )/
                  / / _.   '.   .':      /        '
                  ~(/ .   /    _  `  .-<
                    /_/ . ' .-~" `.  / \  \          ,z=.
                    ( /   '  :   | K   "-.-.__//
                      "-,.    l   I/ \_    _{--->.(==.
                       //(     \  <    ""     //
                      /' /\     \  \     ,v=.  ((
                    .^. / /\     "  }__ //===-  `
                   / / ' '  "-.,__ {---(==-
                 .^ '       :  T  ~"   ll       -Sparrow 
                / .  .  . : | :!        \
               (_/  /   | | j-"          ~^
                                                  
**/

#include <bits/stdc++.h>
using namespace std;
#define pb push_back
#define mp make_pair
#define endl '\n'
#define fo(i, a) for (int i = 0; i < a; i++)
#define fod(i, a, b) for (int i = a; i >= b; i--)
#define ff first
#define ss second
#define FAST_IO              \
    ios::sync_with_stdio(0); \
    cin.tie(0);              \
    cout.tie(0);
#define ip(v)         \
    for (auto &x : v) \
    cin >> x
#define op(v)             \
    for (auto x : v)      \
        cout << x << " "; \
    cout << endl
#define tr(v) for (auto x : v)
#define srt(v) sort(v.begin(), v.end())
#define rev(v) reverse(v.begin(), v.end())
#define clr(x) memset(x, 0, sizeof(x))

typedef long long ll;
typedef vector<ll> vi;
typedef pair<int, int> pii;
typedef vector<pii> vpii;
typedef map<int, int> mii;

const int Mod = 1e9 + 2;
// &*!=
// ()@
//Vikram1234@
void solve()
{
    ll k, n, m;
    cin >> k >> n >> m;
    vi a(n), b(m), ans;
    ip(a);
    ip(b);
    //dd a line is beneficial
    int i = 0, j = 0;
    ll lc = k;
    while (i < n and j < m)
    {
        if (a[i] == 0)
        {
            ans.push_back(a[i]);
            i++;
            lc++;
        }
        else if (b[j] == 0)
        {
            ans.push_back(b[j]);
            j++;
            lc++;
        }
        else
        {

            if (a[i] <= b[j])
            {
                if (a[i] <= lc)
                {
                    ans.push_back(a[i]);
                    i++;
                }
                else
                {
                    cout << "-1\n";
                    return;
                }
            }
            else
            {
                if (b[j] <= lc)
                {
                    ans.push_back(b[j]);
                    j++;
                }
                else
                {
                    cout << "-1\n";
                    return;
                }
            }
        }
    }
    while (i < n)
    {
        if (a[i] == 0)
        {
            lc++;
            ans.push_back(a[i]);
            i++;
        }
        else
        {
            if (a[i] <= lc)
            {
                ans.push_back(a[i]);
                i++;
            }
            else
            {
                cout << "-1\n";
                return;
            }
        }
    }
    while (j < m)
    {
        if (b[j] == 0)
        {
            lc++;
            ans.push_back(b[j]);
            j++;
        }
        else
        {
            if (b[j] <= lc)
            {
                ans.push_back(b[j]);
                j++;
            }
            else
            {
                cout << "-1\n";
                return;
            }
        }
    }
    op(ans);
}
int main()
{

    FAST_IO
    ll t = 1;
    cin >> t;

    while (t--)
    {
        solve();
    }
    return 0;
}