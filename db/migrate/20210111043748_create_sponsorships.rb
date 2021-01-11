class CreateSponsorships < ActiveRecord::Migration[6.0]
  def change
    create_table :sponsorships do |t|
      t.string :name
      t.string :team-id
      t.string :contract-start
      t.string :contract-end

      t.timestamps
    end
  end
end
